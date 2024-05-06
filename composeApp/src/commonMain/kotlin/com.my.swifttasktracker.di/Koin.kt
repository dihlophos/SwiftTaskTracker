package com.my.swifttasktracker.di

import com.my.swifttasktracker.data.IDataSource
import com.my.swifttasktracker.data.SQLiteDataSource
import com.my.swifttasktracker.data.TaskRepository
import com.my.swifttasktracker.domain.ITaskRepository
import com.my.swifttasktracker.ui.createTask.CreateTaskViewModel
import com.my.swifttasktracker.ui.createTask.ICreateTaskViewModel
import com.my.swifttasktracker.ui.taskList.ITaskListViewModel
import com.my.swifttasktracker.ui.taskList.TaskListViewModel
import org.koin.dsl.module

fun appModule() = module {
    single<IDataSource> {
        SQLiteDataSource(
            databaseDriverFactory = get()
        )
    }

    single<ITaskRepository> {
        TaskRepository(
            dataSource = get()
        )
    }

    single<ITaskListViewModel> {
        TaskListViewModel(
            taskRepository = get()
        )
    }

    single<ICreateTaskViewModel> {
        CreateTaskViewModel(
            taskRepository = get()
        )
    }
}