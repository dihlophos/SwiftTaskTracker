package com.my.swifttasktracker.ui.taskList

import com.my.swifttasktracker.domain.models.Task

sealed interface TaskListUiState {
    data object Loading: TaskListUiState
    data class Success(val tasks: List<Task>): TaskListUiState
}