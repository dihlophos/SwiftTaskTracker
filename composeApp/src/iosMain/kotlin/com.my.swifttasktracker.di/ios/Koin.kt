package com.my.swifttasktracker.di.ios

import com.my.swifttasktracker.data.DatabaseDriverFactory
import org.koin.dsl.module

fun iosModule() = module {
    single {
        DatabaseDriverFactory()
    }
}