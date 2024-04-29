package com.my.swifttasktracker.ui.taskList

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.my.swifttasktracker.domain.models.Task

@Composable
fun TaskRow(
    task: Task
) {
    Column {
        Text(text = task.name)
        Text(text = task.createdDate.toString())
        Text(text = task.updatedDate.toString())
    }
}