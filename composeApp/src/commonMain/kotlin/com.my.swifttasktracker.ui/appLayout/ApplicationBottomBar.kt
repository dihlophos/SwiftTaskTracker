package com.my.swifttasktracker.ui.appLayout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.jetbrains.compose.resources.stringResource
import swifttasktracker.composeapp.generated.resources.Res
import swifttasktracker.composeapp.generated.resources.inbox
import swifttasktracker.composeapp.generated.resources.task_list

@Composable
fun ApplicationBottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier,
        actions = {
            IconButton(onClick = {
                navController.navigate(ApplicationScreen.TaskList.name)
            }) {
                Icon(
                    Icons.AutoMirrored.Rounded.List,
                    contentDescription = stringResource(Res.string.task_list))
            }
            IconButton(onClick = {
                //TODO:Inbox Screen
            }) {
                Icon(
                    Icons.Rounded.KeyboardArrowDown,
                    contentDescription = stringResource(Res.string.inbox),
                )
            }
        }
    )
}
