package com.xarhssta.newsmultiplatformdemo.application.article

import com.xarhssta.newsmultiplatformdemo.domain.article.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
