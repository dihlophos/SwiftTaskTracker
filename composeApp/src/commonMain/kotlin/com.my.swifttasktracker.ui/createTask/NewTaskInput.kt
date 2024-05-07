package com.my.swifttasktracker.ui.createTask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.my.swifttasktracker.ui.StringResourceSafeForPreview
import swifttasktracker.composeapp.generated.resources.Res
import swifttasktracker.composeapp.generated.resources.new_task
import swifttasktracker.composeapp.generated.resources.task_description

@Composable
fun NewTaskInput(
    taskDescription: String,
    onValueChange: (String) -> Unit,
    onButtonClick: () -> Unit)
{
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = taskDescription,
            onValueChange = onValueChange,
            label = {
                Text(StringResourceSafeForPreview(Res.string.task_description))
            }
        )

        Button(onClick = onButtonClick) {
            Text(StringResourceSafeForPreview(Res.string.new_task))
        }
    }
}