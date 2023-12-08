package com.my.swifttasktracker.shared.domain.models

import kotlinx.datetime.LocalDateTime

class Task(
    public val name: String,
    public val createdDate: LocalDateTime,
    public val updatedDate: LocalDateTime,
    public val isDeleted: Boolean
)