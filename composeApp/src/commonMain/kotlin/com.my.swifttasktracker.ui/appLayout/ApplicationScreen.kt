package com.my.swifttasktracker.ui.appLayout

import org.jetbrains.compose.resources.StringResource
import swifttasktracker.composeapp.generated.resources.Res
import swifttasktracker.composeapp.generated.resources.allTasks
import swifttasktracker.composeapp.generated.resources.create_task
import swifttasktracker.composeapp.generated.resources.inbox
import swifttasktracker.composeapp.generated.resources.planning
import swifttasktracker.composeapp.generated.resources.today

enum class ApplicationScreen(val title: StringResource) {
    Today(title = Res.string.today),
    Inbox(title = Res.string.inbox),
    Planning(title = Res.string.planning),
    AllTasks(title = Res.string.allTasks),
    CreateTask(title = Res.string.create_task)
}