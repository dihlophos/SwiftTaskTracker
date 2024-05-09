package com.my.swifttasktracker.ui.screens.inbox

import kotlinx.coroutines.flow.StateFlow

interface IInboxViewModel {
    val uiState: StateFlow<InboxUiState>

    var newInboxItemDescription: String

    fun createInboxItem()
}