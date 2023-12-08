package com.my.swifttasktracker.shared.data

import com.my.swifttasktracker.shared.domain.models.Task
import kotlinx.coroutines.flow.Flow

interface IDataSource {
    fun getAllTasks(): Flow<List<Task>>

    fun newTask(name: String)
}