package com.my.swifttasktracker.ui.screens.inbox

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.swifttasktracker.domain.IInboxRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class InboxViewModel(
    private val inboxRepository: IInboxRepository
): ViewModel(), IInboxViewModel {

    override var newInboxItemDescription by mutableStateOf("")

    override val uiState: StateFlow<InboxUiState> =
        inboxRepository
            .getInboxItems()
            .map { inboxItem -> InboxUiState.Success(inboxItem) }
            .stateIn(
                scope=viewModelScope,
                initialValue = InboxUiState.Loading,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000)
            )

    override fun createInboxItem() {
        viewModelScope.launch {
            inboxRepository.createInboxItem(newInboxItemDescription)
        }
    }
}