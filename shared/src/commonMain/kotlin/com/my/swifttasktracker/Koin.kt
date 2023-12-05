package com.my.swifttasktracker

import com.my.swifttasktracker.data.TaskRepositoryImpl
import com.my.swifttasktracker.domain.models.TaskRepository
import org.koin.dsl.module

fun appModule() = module {
    single<TaskRepository> { TaskRepositoryImpl() }
}