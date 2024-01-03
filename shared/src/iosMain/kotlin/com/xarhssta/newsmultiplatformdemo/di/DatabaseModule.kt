package com.xarhssta.newsmultiplatformdemo.di

import app.cash.sqldelight.db.SqlDriver
import com.xarhssta.newsmultiplatformdemo.db.DatabaseDriverFactory
import com.xarhssta.newsmultiplatformdemo.db.NewsMultiplatformDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<NewsMultiplatformDatabase> { NewsMultiplatformDatabase(get()) }
}