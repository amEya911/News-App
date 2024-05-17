package eu.tutorials.news.data.repository

import eu.tutorials.news.data.remote.NewsApi
import eu.tutorials.news.domain.model.Article
import eu.tutorials.news.domain.repository.NewsRepository
import eu.tutorials.news.util.Resource

class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository {
    override suspend fun getTopHeadlines(category: String, country: String): Resource<List<Article>> {
        return try {
            val response = newsApi.getBreakingNews(category = category, country = country)
            Resource.Success(response.articles)
        } catch (e: Exception) {
            Resource.Error(message = "Failed to get news ${e.message}")
        }
    }

    override suspend fun searchForNews(query: String): Resource<List<Article>> {
        return try {
            val response = newsApi.searchForNews(query = query)
            Resource.Success(data = response.articles)
        } catch (e: Exception) {
            Resource.Error(message = "Failed to fetch news ${e.message}")
        }
    }
}