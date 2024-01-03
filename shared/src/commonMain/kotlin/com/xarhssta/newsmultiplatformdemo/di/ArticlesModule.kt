package com.xarhssta.newsmultiplatformdemo.di

import com.xarhssta.newsmultiplatformdemo.data.article.ArticlesDataSource
import com.xarhssta.newsmultiplatformdemo.data.article.ArticlesRepository
import com.xarhssta.newsmultiplatformdemo.data.article.ArticlesService
import com.xarhssta.newsmultiplatformdemo.application.article.ArticlesViewModel
import com.xarhssta.newsmultiplatformdemo.domain.article.FetchArticlesUseCase
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
    single<FetchArticlesUseCase> { FetchArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}