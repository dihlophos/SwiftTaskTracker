package com.my.swifttasktracker.domain.models

import kotlinx.datetime.LocalDateTime

class Task(
    val name: String,
    val createdDate: LocalDateTime,
    val updatedDate: LocalDateTime
)