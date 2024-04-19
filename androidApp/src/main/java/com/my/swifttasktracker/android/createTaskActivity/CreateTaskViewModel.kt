package com.my.swifttasktracker.android.createTaskActivity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.swifttasktracker.shared.domain.models.ITaskRepository
import kotlinx.coroutines.launch

class CreateTaskViewModel(
    private val taskRepository: ITaskRepository
): ViewModel() {
    var taskDescription by mutableStateOf("")

    fun addTask() {
        viewModelScope.launch {
            taskRepository.newTask(taskDescription)
        }
    }
}