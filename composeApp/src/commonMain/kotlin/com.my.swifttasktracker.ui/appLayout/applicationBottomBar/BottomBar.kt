package com.my.swifttasktracker.ui.appLayout.applicationBottomBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
        //TODO: Choose Icons
        ApplicationScreen.Today to Icons.Filled.Favorite,
        ApplicationScreen.Inbox to Icons.Filled.Favorite,
        ApplicationScreen.Planning to Icons.Filled.Favorite,
        ApplicationScreen.AllTasks to Icons.Filled.Favorite,
    )

    NavigationBar (modifier) {
        icons.entries.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.value, contentDescription = item.key.name) },
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
