package com.my.swifttasktracker.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.my.swifttasktracker.domain.models.InboxItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime

class SQLiteDataSource(databaseDriverFactory: DatabaseDriverFactory): IDataSource {
    private val database = SwiftTaskTrackerDb(databaseDriverFactory.createDriver())
    private val inboxQueries = database.inboxQueries

    override fun createInboxItem(inboxItemDescription: String) {
        inboxQueries.insertInboxItem(
            description = inboxItemDescription,
            createdDate = Clock.System.now().toLocalDateTimeString(),
            updatedDate = Clock.System.now().toLocalDateTimeString(),
            isDeleted = false
        )
    }

    override fun getInboxItems(): Flow<List<InboxItem>> {
        return inboxQueries.selectInboxItems(includeDeleted = false)
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map {
                inboxItemDbs -> inboxItemDbs.map {
                    inboxItemDb -> inboxItemDb.toInboxItem()
                }
            }
    }

    private fun InboxDb.toInboxItem(): InboxItem {
        return InboxItem(
            description = description,
            createdDate = LocalDateTime.parse(createdDate),
            updatedDate = LocalDateTime.parse(updatedDate),
            isDeleted = isDeleted
        )
    }
}