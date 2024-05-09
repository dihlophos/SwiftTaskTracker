package com.my.swifttasktracker.di

import com.my.swifttasktracker.data.IDataSource
import com.my.swifttasktracker.data.SQLiteDataSource
import com.my.swifttasktracker.data.InboxRepository
import com.my.swifttasktracker.domain.IInboxRepository
import com.my.swifttasktracker.ui.screens.inbox.IInboxViewModel
import com.my.swifttasktracker.ui.screens.inbox.InboxViewModel
import org.koin.dsl.module

fun appModule() = module {
    single<IDataSource> {
        SQLiteDataSource(
            databaseDriverFactory = get()
        )
    }

    single<IInboxRepository> {
        InboxRepository(
            dataSource = get()
        )
    }

    single<IInboxViewModel> {
        InboxViewModel(
            inboxRepository = get()
        )
    }
}