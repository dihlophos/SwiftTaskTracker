package com.my.swifttasktracker.ui.screens.inbox.createInboxItem

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.my.swifttasktracker.ui.screens.inbox.IInboxViewModel
import org.koin.compose.koinInject

@Composable
fun CreateInboxItemScreen(
    navController: NavHostController,
    viewModel: IInboxViewModel = koinInject()
) {
    InboxItemForm(
        inboxItemDescription = viewModel.newInboxItemDescription,
        onValueChange = { viewModel.newInboxItemDescription = it },
        onButtonClick = {
            viewModel.createInboxItem()
            navController.popBackStack()
        }
    )
}