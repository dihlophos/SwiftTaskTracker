package com.my.swifttasktracker.data.samples

import com.my.swifttasktracker.domain.models.Task
import kotlinx.datetime.LocalDateTime

class TaskSamples {
    companion object {
        private val date = LocalDateTime.parse("2024-05-06T16:59:43.123456789")

        val tasks = listOf(
            Task(
                name="Pay rent",
                createdDate= date,
                updatedDate = date,
                isDeleted = false),
            Task(
                name="Call mom❤",
                createdDate= date,
                updatedDate = date,
                isDeleted = false)
        )
    }
}