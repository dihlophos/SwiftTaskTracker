package com.my.swifttasktracker.ui.appLayout.applicationBottomBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.my.swifttasktracker.ui.appLayout.ApplicationScreen

@Composable
fun BottomBar(
    navigate: (ApplicationScreen) -> Unit,
    currentScreen: ApplicationScreen = ApplicationScreen.Today,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    val icons = linkedMapOf(
        ApplicationScreen.Today to Icons.Filled.WbSunny,
        ApplicationScreen.Inbox to Icons.Filled.Inbox,
        ApplicationScreen.Planning to Icons.Filled.SelfImprovement,
        ApplicationScreen.AllTasks to Icons.Filled.AccountTree
    )

    NavigationBar (modifier) {
        icons.entries.forEach{ pair ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = pair.value,
                        contentDescription = pair.key.name
                    )
                },
                label = { Text(pair.key.name) },
                selected = pair.key.name == currentScreen.name,
                onClick = { navigate(pair.key) }
            )
        }
    }
}
