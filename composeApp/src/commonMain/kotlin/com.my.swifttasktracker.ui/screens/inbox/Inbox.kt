package com.my.swifttasktracker.ui.screens.inbox

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.my.swifttasktracker.domain.models.InboxItem

@Composable
fun Inbox(inboxItems: List<InboxItem>) {
    LazyColumn(
      modifier = Modifier.fillMaxWidth()
    ) {
        items(inboxItems) { inboxItem ->
            InboxItem(inboxItem)
            HorizontalDivider()
        }
    }
}