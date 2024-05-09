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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.my.swifttasktracker.ui.appLayout.ApplicationScreen

@Composable
fun BottomBar(
    onNavigate: (ApplicationScreen) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    var selectedItem by remember { mutableIntStateOf(0) }

    val icons = linkedMapOf(
        ApplicationScreen.Today to Icons.Filled.WbSunny,
        ApplicationScreen.Inbox to Icons.Filled.Inbox,
        ApplicationScreen.Planning to Icons.Filled.SelfImprovement,
        ApplicationScreen.AllTasks to Icons.Filled.AccountTree
    )

    NavigationBar (modifier) {
        icons.entries.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.value,
                        contentDescription = item.key.name
                    )
                },
                label = { Text(item.key.name) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    onNavigate(item.key)
                }
            )
        }
    }
}
