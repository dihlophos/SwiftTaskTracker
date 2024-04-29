package com.my.swifttasktracker.ui.createTask

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.koin.compose.koinInject

@Composable
fun CreateTaskScreen(
    viewModel: ICreateTaskViewModel = koinInject(),
    navController: NavHostController
) {
    Column {
        NewTaskInput(viewModel, navController)
    }
}