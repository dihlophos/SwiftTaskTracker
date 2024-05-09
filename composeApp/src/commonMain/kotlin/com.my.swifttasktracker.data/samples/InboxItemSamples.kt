package com.my.swifttasktracker.data.samples

import com.my.swifttasktracker.domain.models.InboxItem
import kotlinx.datetime.LocalDateTime

class InboxItemSamples {
    companion object {
        private val date = LocalDateTime.parse("2024-05-06T16:59:43.123456789")

        val inboxItems = listOf(
            InboxItem(
                description="Pay rent",
                createdDate= date,
                updatedDate = date,
                isDeleted = false),
            InboxItem(
                description="Call mom❤",
                createdDate= date,
                updatedDate = date,
                isDeleted = false)
        )
    }
}