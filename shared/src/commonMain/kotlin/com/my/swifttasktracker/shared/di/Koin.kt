package com.my.swifttasktracker.shared.di

import com.my.swifttasktracker.shared.data.IDataSource
import com.my.swifttasktracker.shared.data.SQLiteDataSource
import com.my.swifttasktracker.shared.data.TaskRepository
import com.my.swifttasktracker.shared.domain.models.ITaskRepository
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
}