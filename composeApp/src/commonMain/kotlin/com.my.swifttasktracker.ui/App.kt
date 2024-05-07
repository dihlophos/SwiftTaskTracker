package com.my.swifttasktracker.ui

import androidx.compose.runtime.Composable
import com.my.swifttasktracker.ui.appLayout.AppLayout
import com.my.swifttasktracker.ui.theme.SwiftTaskTrackerTheme
import org.koin.compose.KoinContext

@Composable
fun App() {
    KoinContext {
        SwiftTaskTrackerTheme {
            AppLayout()
        }
    }
}