package com.my.swifttasktracker.shared.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.my.swifttasktracker.shared.domain.models.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime

class SQLiteDataSource(databaseDriverFactory: DatabaseDriverFactory): IDataSource {
    private val database = SwiftTaskTrackerDb(databaseDriverFactory.createDriver())
    private val taskQuery = database.taskQueries

    override fun newTask(name: String) {
        taskQuery.insertTask(
            taskName = name,
            createdDate = Clock.System.now().toLocalDateTimeString(),
            updatedDate = Clock.System.now().toLocalDateTimeString(),
            isDeleted = false.toString()
        )
    }

    override fun getAllTasks(): Flow<List<Task>> {
        return taskQuery.selectAllTasks()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { tasks -> tasks.map { task -> task.toTask() } }
    }

    private fun TaskDb.toTask(): Task {
        return Task(
            name = taskName,
            createdDate = LocalDateTime.parse(createdDate),
            updatedDate = LocalDateTime.parse(updatedDate),
            isDeleted = isDeleted.toBoolean()
        )
    }
}