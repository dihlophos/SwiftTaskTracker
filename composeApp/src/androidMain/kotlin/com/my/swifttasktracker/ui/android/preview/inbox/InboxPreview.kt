package com.my.swifttasktracker.ui.android.preview.inbox

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.my.swifttasktracker.data.samples.InboxItemSamples
import com.my.swifttasktracker.ui.android.preview.annotations.ThemePreviews
import com.my.swifttasktracker.ui.screens.inbox.Inbox
import com.my.swifttasktracker.ui.theme.SwiftTaskTrackerTheme

@ThemePreviews
@Composable
fun InboxPreview() {
    SwiftTaskTrackerTheme {
        Surface {
            Inbox(InboxItemSamples.inboxItems)
        }
    }
}