package com.my.swifttasktracker.ui.createTask

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.swifttasktracker.domain.ITaskRepository
import kotlinx.coroutines.launch

class CreateTaskViewModel(
    private val taskRepository: ITaskRepository
): ViewModel(), ICreateTaskViewModel {
    override var taskDescription by mutableStateOf("")

    override fun addTask() {
        viewModelScope.launch {
            taskRepository.newTask(taskDescription)
        }
    }
}