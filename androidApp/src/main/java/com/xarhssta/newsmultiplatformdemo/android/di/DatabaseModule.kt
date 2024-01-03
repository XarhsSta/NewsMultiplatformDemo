package com.xarhssta.newsmultiplatformdemo.android.di

import app.cash.sqldelight.db.SqlDriver
import com.xarhssta.newsmultiplatformdemo.db.DatabaseDriverFactory
import com.xarhssta.newsmultiplatformdemo.db.NewsMultiplatformDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<NewsMultiplatformDatabase> { NewsMultiplatformDatabase(get()) }
}