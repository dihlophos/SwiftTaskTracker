package com.my.swifttasktracker.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.my.swifttasktracker.ui.appLayout.AppLayout
import org.koin.compose.KoinContext

@Composable
fun App() {
    KoinContext {
        MaterialTheme {
            AppLayout()
        }
    }
}