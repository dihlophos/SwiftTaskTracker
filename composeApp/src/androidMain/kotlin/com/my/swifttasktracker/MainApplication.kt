package com.my.swifttasktracker

import android.app.Application
import com.my.swifttasktracker.di.android.androidModule
import com.my.swifttasktracker.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


//open class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                appModule(),
                androidModule()
            )
        }
    }
}