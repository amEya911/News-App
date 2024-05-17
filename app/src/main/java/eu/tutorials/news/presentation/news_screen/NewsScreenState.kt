package eu.tutorials.news.presentation.news_screen

import eu.tutorials.news.domain.model.Article

data class NewsScreenState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String? = null,
    val isSearchBarVisible: Boolean= false,
    val selectedArticle: Article? = null,
    val category: String = "General",
    val country: String = "in",
    val searchQuery: String = ""
)