package com.my.swifttasktracker.ui.android.preview.taskList

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.my.swifttasktracker.data.samples.TaskSamples
import com.my.swifttasktracker.ui.android.preview.annotations.ThemePreviews
import com.my.swifttasktracker.ui.taskList.TaskList
import com.my.swifttasktracker.ui.theme.SwiftTaskTrackerTheme

@ThemePreviews
@Composable
fun TaskListPreview() {
    SwiftTaskTrackerTheme {
        Surface {
            TaskList(TaskSamples.tasks)
        }
    }
}