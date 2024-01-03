package com.xarhssta.newsmultiplatformdemo.android.di

import com.xarhssta.newsmultiplatformdemo.application.article.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
}