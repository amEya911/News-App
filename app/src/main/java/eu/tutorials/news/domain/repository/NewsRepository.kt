package eu.tutorials.news.domain.repository

import eu.tutorials.news.domain.model.Article
import eu.tutorials.news.util.Resource

interface NewsRepository {

    suspend fun getTopHeadlines(
        category: String,
        country: String
    ): Resource<List<Article>>

    suspend fun searchForNews(
        query: String
    ): Resource<List<Article>>

}

