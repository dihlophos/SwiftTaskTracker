package com.my.swifttasktracker.data

import com.my.swifttasktracker.domain.ITaskRepository
import com.my.swifttasktracker.domain.models.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val dataSource: IDataSource) :
    ITaskRepository {
    override fun getAllTasks(): Flow<List<Task>> {
        return dataSource.getAllTasks()
    }

    override fun newTask(name: String) {
        dataSource.newTask(name)
    }
}