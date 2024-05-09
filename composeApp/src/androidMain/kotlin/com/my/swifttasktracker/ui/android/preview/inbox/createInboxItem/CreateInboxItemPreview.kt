package com.my.swifttasktracker.ui.android.preview.inbox.createInboxItem

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.my.swifttasktracker.ui.android.preview.annotations.ThemePreviews
import com.my.swifttasktracker.ui.screens.inbox.createInboxItem.InboxItemForm
import com.my.swifttasktracker.ui.theme.SwiftTaskTrackerTheme

@ThemePreviews
@Composable
fun CreateInboxItemPreview() {
    SwiftTaskTrackerTheme {
        Surface {
            InboxItemForm(
                inboxItemDescription = "\uD83C\uDF7A Grab some beer",
                onValueChange = {},
                onButtonClick = {}
            )
        }
    }
}
