package com.my.swifttasktracker.data

import com.my.swifttasktracker.domain.IInboxRepository
import com.my.swifttasktracker.domain.models.InboxItem
import kotlinx.coroutines.flow.Flow

class InboxRepository(private val dataSource: IDataSource) :
    IInboxRepository {
    override fun getInboxItems(): Flow<List<InboxItem>> {
        return dataSource.getInboxItems()
    }

    override fun createInboxItem(inboxItemDescription: String) {
        dataSource.createInboxItem(inboxItemDescription)
    }
}