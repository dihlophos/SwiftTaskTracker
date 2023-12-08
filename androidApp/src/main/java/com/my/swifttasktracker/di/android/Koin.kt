package com.my.swifttasktracker.di.android

import com.my.swifttasktracker.android.taskListActivity.TaskListViewModel
import com.my.swifttasktracker.shared.data.DatabaseDriverFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun androidModule() = module {
    single {
        DatabaseDriverFactory(context = get())
    }

    viewModel {
        TaskListViewModel(
            taskRepository = get()
        )
    }
}