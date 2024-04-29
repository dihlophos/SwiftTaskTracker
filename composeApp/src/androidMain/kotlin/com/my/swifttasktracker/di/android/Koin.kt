package com.my.swifttasktracker.di.android

import com.my.swifttasktracker.data.DatabaseDriverFactory
import org.koin.dsl.module

fun androidModule() = module {
    single {
        DatabaseDriverFactory(context = get())
    }
}