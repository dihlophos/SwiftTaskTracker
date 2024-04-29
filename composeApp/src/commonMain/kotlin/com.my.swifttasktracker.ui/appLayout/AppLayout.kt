package com.my.swifttasktracker.ui.appLayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.my.swifttasktracker.ui.createTask.CreateTaskScreen
import com.my.swifttasktracker.ui.taskList.TaskListScreen

@Composable
fun AppLayout(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = ApplicationScreen.valueOf(
        backStackEntry?.destination?.route ?: ApplicationScreen.TaskList.name
    )

    Scaffold(
        topBar = {
            ApplicationTopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                modifier = Modifier.fillMaxWidth()
            )
        },
        bottomBar = {
            ApplicationBottomBar(
                navController = navController,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ApplicationScreen.TaskList.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
        {
            composable(route = ApplicationScreen.TaskList.name) {
                TaskListScreen(
                    navController=navController
                )
            }
            composable(route = ApplicationScreen.CreateTask.name) {
                CreateTaskScreen(
                    navController = navController
                )
            }
        }
    }
}