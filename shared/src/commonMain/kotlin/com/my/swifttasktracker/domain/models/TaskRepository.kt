package com.my.swifttasktracker.domain.models

interface TaskRepository {
    fun getAllTasks(): List<Task>
}