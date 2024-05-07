package com.my.swifttasktracker.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

/*
    Quick fix for exception in @Previews in Android Studio caused by KMM Composable Resources
    See https://github.com/JetBrains/compose-multiplatform/issues/4476
 */
@Composable
fun StringResourceSafeForPreview(resource: StringResource): String {
    val isPreview = LocalInspectionMode.current

    if (!isPreview) {
        return stringResource(resource)
    }

    return "[Preview Text]"
}