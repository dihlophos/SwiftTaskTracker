package com.my.swifttasktracker.ui.taskList

import kotlinx.coroutines.flow.StateFlow

interface ITaskListViewModel {
    val uiState: StateFlow<TaskListUiState>
}