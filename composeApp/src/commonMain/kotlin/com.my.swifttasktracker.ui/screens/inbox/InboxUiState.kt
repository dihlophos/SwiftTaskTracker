package com.my.swifttasktracker.ui.screens.inbox

import com.my.swifttasktracker.domain.models.InboxItem

sealed interface InboxUiState {
    data object Loading: InboxUiState
    data class Success(val inboxItems: List<InboxItem>): InboxUiState
}