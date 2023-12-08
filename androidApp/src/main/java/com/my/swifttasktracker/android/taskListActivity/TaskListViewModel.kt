package com.my.swifttasktracker.android.taskListActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.swifttasktracker.shared.domain.models.ITaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskListViewModel(
    private val taskRepository: ITaskRepository
): ViewModel() {
    val uiState: StateFlow<TaskListUiState> =
        taskRepository
            .getAllTasks()
            .map { task -> TaskListUiState.Success(task) }
            .stateIn(
                scope=viewModelScope,
                initialValue = TaskListUiState.Loading,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000)
            )

    fun addTask(name: String) {
        viewModelScope.launch {
            taskRepository.newTask(name)
        }
    }
}