package com.my.swifttasktracker.domain.models

import kotlinx.datetime.LocalDateTime

class InboxItem(
    val description: String,
    val createdDate: LocalDateTime,
    val updatedDate: LocalDateTime,
    @Suppress("unused")
    val isDeleted: Boolean
)