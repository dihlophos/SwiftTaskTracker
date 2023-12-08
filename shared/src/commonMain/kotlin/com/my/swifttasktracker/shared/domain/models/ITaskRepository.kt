package com.my.swifttasktracker.shared.domain.models

import kotlinx.coroutines.flow.Flow

interface ITaskRepository {
    fun getAllTasks(): Flow<List<Task>>

    fun newTask(name: String)
}