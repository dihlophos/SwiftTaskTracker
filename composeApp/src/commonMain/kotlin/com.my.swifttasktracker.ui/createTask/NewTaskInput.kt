package com.my.swifttasktracker.ui.createTask

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.jetbrains.compose.resources.stringResource
import swifttasktracker.composeapp.generated.resources.Res
import swifttasktracker.composeapp.generated.resources.new_task
import swifttasktracker.composeapp.generated.resources.task_description

@Composable
fun NewTaskInput(viewModel: ICreateTaskViewModel, navController: NavHostController) {
    TextField(
        value = viewModel.taskDescription,
        onValueChange = { viewModel.taskDescription=it },
        label = {
            Text(stringResource(Res.string.task_description))
        }
    )

    Button(onClick = {
        viewModel.addTask()
        navController.popBackStack()
    }) {
        Text(stringResource(Res.string.new_task))
    }
}