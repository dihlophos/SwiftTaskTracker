package com.my.swifttasktracker.android.taskListActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.my.swifttasktracker.shared.domain.models.Task
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinContext

class TaskListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinContext {
                TaskListScreen()
            }
        }
    }
}

@Composable
fun NewTaskInput(viewModel: TaskListViewModel) {
    var taskName by remember { mutableStateOf("") }

    TextField(
        value = taskName,
        onValueChange = {
            taskName = it
        },
        label = { Text("Task Name") }
    )

    Button(onClick = {
        viewModel.addTask(taskName)
        taskName = ""
    }) {
        Text("New Task")
    }
}

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

@Composable
fun TaskList(tasks: List<Task>) {
    LazyColumn {
        items(tasks) { task ->
            TaskRow(task)
            Divider()
        }
    }
}

@Composable
fun TaskListScreen() {
    val viewModel = koinViewModel<TaskListViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        TaskListUiState.Loading -> { Text("Loading") }
        is TaskListUiState.Success -> {
            Column {
                NewTaskInput(viewModel)
                TaskList(tasks = (uiState as TaskListUiState.Success).tasks)
            }
        }
    }
}
