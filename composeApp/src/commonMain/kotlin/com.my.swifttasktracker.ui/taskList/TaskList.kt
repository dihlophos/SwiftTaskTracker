package com.my.swifttasktracker.ui.taskList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.my.swifttasktracker.domain.models.Task

@Composable
fun TaskList(tasks: List<Task>) {
    LazyColumn(
      modifier = Modifier.fillMaxWidth()
    ) {
        items(tasks) { task ->
            TaskRow(task)
            HorizontalDivider()
        }
    }
}