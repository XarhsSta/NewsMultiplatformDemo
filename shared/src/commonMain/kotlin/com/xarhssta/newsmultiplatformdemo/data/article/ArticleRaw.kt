package com.xarhssta.newsmultiplatformdemo.data.article

import com.xarhssta.newsmultiplatformdemo.domain.article.Article
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.math.abs

@Serializable
data class ArticleRaw(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String?,
    @SerialName("publishedAt")
    val date: String,
    @SerialName("urlToImage")
    val imageUrl: String?
) {
    companion object {
        fun ArticleRaw.toArticle(): Article = Article(
            title = title,
            description = description ?: "",
            date = getDaysString(date),
            imageUrl = imageUrl ?: ""
        )
    }
}

private fun getDaysString(date: String): String {
    val days = Clock.System
        .todayIn(TimeZone.currentSystemDefault())
        .daysUntil(
            Instant
                .parse(date)
                .toLocalDateTime(TimeZone.currentSystemDefault())
                .date
        )

    return when {
        abs(days) > 1 -> "${abs(days)} days ago"
        abs(days) == 1 -> "Yesterday"
        else -> "Today"
    }
}