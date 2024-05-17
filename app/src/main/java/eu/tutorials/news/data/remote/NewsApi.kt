package eu.tutorials.news.data.remote

import eu.tutorials.news.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    // https://newsapi.org/v2/top-headlines?country=us&apiKey=7793158c0f474ec6a3005bc286747882

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category") category: String,
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun searchForNews(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "7793158c0f474ec6a3005bc286747882"
    }
}