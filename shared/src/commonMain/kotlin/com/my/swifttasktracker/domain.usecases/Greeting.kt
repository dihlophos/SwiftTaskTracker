package com.my.swifttasktracker.domain.usecases

import com.my.swifttasktracker.domain.models.Task
import com.my.swifttasktracker.domain.models.TaskRepository

class Greeting(private val taskRepository: TaskRepository) {

    fun greet(): List<Task> {
        return taskRepository.getAllTasks()
    }
}