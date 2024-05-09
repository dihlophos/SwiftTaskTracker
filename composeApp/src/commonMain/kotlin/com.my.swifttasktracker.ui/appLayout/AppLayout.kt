package com.my.swifttasktracker.ui.appLayout

import androidx.compose.foundation.layout.fillMaxSize
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
import com.my.swifttasktracker.ui.appLayout.applicationBottomBar.BottomBar
import com.my.swifttasktracker.ui.appLayout.applicationTopBar.TopBar
import com.my.swifttasktracker.ui.createTask.CreateTaskScreen
import com.my.swifttasktracker.ui.taskList.TaskListScreen

@Composable
fun AppLayout(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = ApplicationScreen.valueOf(
        backStackEntry?.destination?.route ?: ApplicationScreen.Today.name
    )

    Scaffold(
        topBar = {
            TopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        },
        bottomBar = {
            BottomBar(
                onNavigate = { screen -> navController.navigate(screen.name) },
            )
        }
    ) {
        innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ApplicationScreen.Today.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
        {
            composable(route = ApplicationScreen.Today.name) {
                TaskListScreen(
                    navController=navController
                )
            }
            composable(route = ApplicationScreen.Inbox.name) {
                TaskListScreen(
                    navController=navController
                )
            }
            composable(route = ApplicationScreen.Planning.name) {
                CreateTaskScreen(
                    navController = navController
                )
            }
            composable(route = ApplicationScreen.AllTasks.name) {
                CreateTaskScreen(
                    navController = navController
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