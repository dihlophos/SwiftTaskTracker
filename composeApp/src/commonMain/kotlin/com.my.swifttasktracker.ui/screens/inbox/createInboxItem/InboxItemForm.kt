package com.my.swifttasktracker.ui.screens.inbox.createInboxItem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.my.swifttasktracker.ui.StringResourceSafeForPreview
import swifttasktracker.composeapp.generated.resources.Res
import swifttasktracker.composeapp.generated.resources.create_inbox_item
import swifttasktracker.composeapp.generated.resources.description

@Composable
fun InboxItemForm(
    inboxItemDescription: String,
    onValueChange: (String) -> Unit,
    onButtonClick: () -> Unit)
{
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = inboxItemDescription,
            onValueChange = onValueChange,
            label = {
                Text(StringResourceSafeForPreview(Res.string.description))
            }
        )

        Button(onClick = onButtonClick) {
            Text(StringResourceSafeForPreview(Res.string.create_inbox_item))
        }
    }
}