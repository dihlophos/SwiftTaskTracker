package com.my.swifttasktracker.ui.android.preview.createTask

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.my.swifttasktracker.ui.android.preview.annotations.ThemePreviews
import com.my.swifttasktracker.ui.createTask.NewTaskInput
import com.my.swifttasktracker.ui.theme.SwiftTaskTrackerTheme

@ThemePreviews
@Composable
fun CreateTaskPreview() {
    SwiftTaskTrackerTheme {
        Surface {
            NewTaskInput(
                taskDescription = "\uD83C\uDF7A Grab some beer",
                onValueChange = {},
                onButtonClick = {}
            )
        }
    }
}
