package com.my.swifttasktracker.android.taskListActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.my.swifttasktracker.android.R
import com.my.swifttasktracker.android.createTaskActivity.CreateTaskActivity
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
            HorizontalDivider()
        }
    }
}

@Composable
fun TaskListScreen() {
    val viewModel = koinViewModel<TaskListViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    when (uiState) {
        TaskListUiState.Loading -> { Text(stringResource(R.string.loading)) }
        is TaskListUiState.Success -> {
            Column {
                Button(onClick = {
                    context.startActivity(Intent(context, CreateTaskActivity::class.java))
                }) {
                    Text(text = stringResource(R.string.new_task))
                }
                TaskList(tasks = (uiState as TaskListUiState.Success).tasks)
            }
        }
    }
}
