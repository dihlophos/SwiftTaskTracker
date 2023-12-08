package com.my.swifttasktracker.shared.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(SwiftTaskTrackerDb.Schema, "SwiftTaskTracker.db")
    }
}