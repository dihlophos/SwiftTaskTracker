package com.my.swifttasktracker.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.my.swifttasktracker.data.generated.SwiftTaskTrackerDb

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(SwiftTaskTrackerDb.Schema, context, "SwiftTaskTracker.db")
    }
}