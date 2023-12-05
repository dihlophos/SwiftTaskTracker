package com.my.swifttasktracker.data

import com.my.swifttasktracker.domain.models.TaskRepository
import com.my.swifttasktracker.domain.models.Task

class TaskRepositoryImpl : TaskRepository {
    override fun getAllTasks(): List<Task> {
        val mock = arrayOf("task1", "task2", "task3", "task4")

        return mock.map { task -> Task(task) }
    }
}