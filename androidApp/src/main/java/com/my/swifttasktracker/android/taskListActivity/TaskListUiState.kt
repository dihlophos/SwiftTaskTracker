package com.my.swifttasktracker.android.taskListActivity

import com.my.swifttasktracker.shared.domain.models.Task

sealed interface TaskListUiState {
    data object Loading: TaskListUiState
    data class Success(val tasks: List<Task>): TaskListUiState
}