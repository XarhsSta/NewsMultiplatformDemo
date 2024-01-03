package com.xarhssta.newsmultiplatformdemo.data.article

import com.xarhssta.newsmultiplatformdemo.domain.article.Article

class ArticlesRepository(
    private val service: ArticlesService,
    private val dataSource: ArticlesDataSource
) {
    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        if(forceFetch) {
            dataSource.removeAllArticles()
            return fetchArticles()
        }

        val articlesDb = dataSource.getAllArticles()

        if (articlesDb.isEmpty()) {
            return fetchArticles()
        }

        return articlesDb.map { it.toArticle() }
    }

    private suspend fun fetchArticles(): List<Article> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles.map { it.toArticle() }
    }

}