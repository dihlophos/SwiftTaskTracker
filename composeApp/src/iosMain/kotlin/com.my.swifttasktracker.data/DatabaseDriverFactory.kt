@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.my.swifttasktracker.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.my.swifttasktracker.data.generated.SwiftTaskTrackerDb

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(SwiftTaskTrackerDb.Schema, "SwiftTaskTracker.db")
    }
}