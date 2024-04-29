package com.my.swifttasktracker.ui.taskList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.swifttasktracker.domain.models.ITaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskListViewModel(
    private val taskRepository: ITaskRepository
): ViewModel(), ITaskListViewModel {
    override val uiState: StateFlow<TaskListUiState> =
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