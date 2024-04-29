package com.my.swifttasktracker.data

import com.my.swifttasktracker.domain.models.Task
import kotlinx.coroutines.flow.Flow

interface IDataSource {
    fun getAllTasks(): Flow<List<Task>>

    fun newTask(name: String)
}