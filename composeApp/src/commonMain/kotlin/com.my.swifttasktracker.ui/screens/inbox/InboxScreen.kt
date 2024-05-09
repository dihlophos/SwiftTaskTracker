package com.my.swifttasktracker.ui.screens.inbox

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.my.swifttasktracker.ui.appLayout.ApplicationScreen
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import swifttasktracker.composeapp.generated.resources.Res
import swifttasktracker.composeapp.generated.resources.create_inbox_item
import swifttasktracker.composeapp.generated.resources.loading

@Composable
fun InboxScreen(
    navController: NavHostController,
    viewModel: IInboxViewModel = koinInject()
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        InboxUiState.Loading -> { Text(stringResource(Res.string.loading)) }
        is InboxUiState.Success -> {
            Column {
                Button(onClick = {
                    navController.navigate(ApplicationScreen.CreateInboxItem.name)
                }) {
                    Text(text = stringResource(Res.string.create_inbox_item))
                }
                Inbox(inboxItems = (uiState as InboxUiState.Success).inboxItems)
            }
        }
    }
}