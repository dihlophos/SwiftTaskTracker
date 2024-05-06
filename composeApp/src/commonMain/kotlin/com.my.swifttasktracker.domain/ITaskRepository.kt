package com.my.swifttasktracker.domain

import com.my.swifttasktracker.domain.models.Task
import kotlinx.coroutines.flow.Flow

interface ITaskRepository {
    fun getAllTasks(): Flow<List<Task>>

    fun newTask(name: String)
}