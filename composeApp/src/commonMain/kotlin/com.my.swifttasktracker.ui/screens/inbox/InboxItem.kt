package com.my.swifttasktracker.ui.screens.inbox

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.my.swifttasktracker.domain.models.InboxItem

@Composable
fun InboxItem(
    inboxItem: InboxItem
) {
    Column {
        Text(text = inboxItem.description)
        Text(text = inboxItem.createdDate.toString())
        Text(text = inboxItem.updatedDate.toString())
    }
}