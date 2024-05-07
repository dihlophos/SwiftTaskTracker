package com.my.swifttasktracker.ui.createTask

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.koin.compose.koinInject

@Composable
fun CreateTaskScreen(
    navController: NavHostController,
    viewModel: ICreateTaskViewModel = koinInject()
) {
    NewTaskInput(
        taskDescription = viewModel.taskDescription,
        onValueChange = { viewModel.taskDescription = it },
        onButtonClick = {
            viewModel.addTask()
            navController.popBackStack()
        }
    )
}