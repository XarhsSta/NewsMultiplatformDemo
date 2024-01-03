package com.xarhssta.newsmultiplatformdemo.domain.article

import com.xarhssta.newsmultiplatformdemo.data.article.ArticlesRepository

class FetchArticlesUseCase(
    private val repository: ArticlesRepository
) {
    suspend fun fetchArticles(forceFetch: Boolean): List<Article> {
        return repository.getArticles(forceFetch)
    }
}