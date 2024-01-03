package com.xarhssta.newsmultiplatformdemo.data.article

import com.xarhssta.newsmultiplatformdemo.db.NewsMultiplatformDatabase

class ArticlesDataSource(private val database: NewsMultiplatformDatabase) {
    fun getAllArticles(): List<ArticleRaw> = database
        .newsMultiplatformDatabaseQueries
        .selectAll(::mapToArticleRaw)
        .executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.newsMultiplatformDatabaseQueries.transaction {
            articles.forEach {
                insertArticle(it)
            }
        }
    }

    fun removeAllArticles() = database.newsMultiplatformDatabaseQueries.removeAllArticles()

    private fun mapToArticleRaw(
        title: String,
        description: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw = ArticleRaw(
        title = title,
        description = description,
        date = date,
        imageUrl = imageUrl
    )

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.newsMultiplatformDatabaseQueries.insertArticle(
            title = articleRaw.title,
            description = articleRaw.description,
            date = articleRaw.date,
            imageUrl = articleRaw.imageUrl
        )
    }
}