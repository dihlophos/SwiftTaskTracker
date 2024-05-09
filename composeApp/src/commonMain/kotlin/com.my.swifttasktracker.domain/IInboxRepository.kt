package com.my.swifttasktracker.domain

import com.my.swifttasktracker.domain.models.InboxItem
import kotlinx.coroutines.flow.Flow

interface IInboxRepository {
    fun getInboxItems(): Flow<List<InboxItem>>

    fun createInboxItem(inboxItemDescription: String)
}