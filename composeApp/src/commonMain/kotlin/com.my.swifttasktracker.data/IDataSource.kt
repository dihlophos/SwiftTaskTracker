package com.my.swifttasktracker.data

import com.my.swifttasktracker.domain.models.InboxItem
import kotlinx.coroutines.flow.Flow

interface IDataSource {
    fun getInboxItems(): Flow<List<InboxItem>>

    fun createInboxItem(inboxItemDescription: String)
}