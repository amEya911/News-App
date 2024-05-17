package eu.tutorials.news.util

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object NewsScreen: Screen("news_screen")
    object ArticleScreen: Screen("article_screen")
}