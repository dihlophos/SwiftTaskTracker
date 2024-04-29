package com.my.swifttasktracker.ui.taskList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.my.swifttasktracker.domain.models.Task
import com.my.swifttasktracker.ui.appLayout.ApplicationScreen
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import swifttasktracker.composeapp.generated.resources.Res
import swifttasktracker.composeapp.generated.resources.loading
import swifttasktracker.composeapp.generated.resources.new_task

@Composable
fun TaskListScreen(
    viewModel: ITaskListViewModel = koinInject(),
    navController: NavHostController
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        TaskListUiState.Loading -> { Text(stringResource(Res.string.loading)) }
        is TaskListUiState.Success -> {
            Column {
                Button(onClick = {
                    navController.navigate(ApplicationScreen.CreateTask.name)
                }) {
                    Text(text = stringResource(Res.string.new_task))
                }
                TaskList(tasks = (uiState as TaskListUiState.Success).tasks)
            }
        }
    }
}