package com.my.swifttasktracker.ui.createTask

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.koin.compose.koinInject

@Composable
fun CreateTaskScreen(
    navController: NavHostController,
    viewModel: ICreateTaskViewModel = koinInject()
) {
    Column {
        NewTaskInput(viewModel, navController)
    }
}