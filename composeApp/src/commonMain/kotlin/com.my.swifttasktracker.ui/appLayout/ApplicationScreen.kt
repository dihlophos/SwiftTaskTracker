package com.my.swifttasktracker.ui.appLayout

import org.jetbrains.compose.resources.StringResource
import swifttasktracker.composeapp.generated.resources.Res
import swifttasktracker.composeapp.generated.resources.create_task
import swifttasktracker.composeapp.generated.resources.task_list

enum class ApplicationScreen(val title: StringResource) {
    TaskList(title = Res.string.task_list),
    CreateTask(title = Res.string.create_task)
}