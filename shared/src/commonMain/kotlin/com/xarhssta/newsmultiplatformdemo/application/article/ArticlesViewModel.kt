package com.xarhssta.newsmultiplatformdemo.application.article

import com.xarhssta.newsmultiplatformdemo.BaseViewModel
import com.xarhssta.newsmultiplatformdemo.domain.article.FetchArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(private val fetchArticlesUseCase: FetchArticlesUseCase): BaseViewModel() {
    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.emit(ArticlesState(loading = true))
            val fetchedArticles = fetchArticlesUseCase.fetchArticles(forceFetch)
            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}