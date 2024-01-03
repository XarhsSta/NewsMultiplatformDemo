package com.xarhssta.newsmultiplatformdemo.android

import android.app.Application
import com.xarhssta.newsmultiplatformdemo.android.di.databaseModule
import com.xarhssta.newsmultiplatformdemo.android.di.viewModelsModule
import com.xarhssta.newsmultiplatformdemo.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsMultiplatformApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelsModule + databaseModule
        startKoin {
            androidContext(this@NewsMultiplatformApp)
            modules(modules)
        }
    }
}