package eu.tutorials.news.util

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import eu.tutorials.news.presentation.article_screen.ArticleScreen
import eu.tutorials.news.presentation.news_screen.MainScreen
import eu.tutorials.news.presentation.news_screen.NewsScreen
import eu.tutorials.news.presentation.news_screen.NewsScreenViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {

        composable(Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }


        composable("${Screen.NewsScreen.route}/{country}",
            arguments = listOf(navArgument(name = "country") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val country = backStackEntry.arguments?.getString("country") ?: "India"
            val viewModel: NewsScreenViewModel = hiltViewModel()
            NewsScreen(
                country = country,
                state = viewModel.state,
                onEvent = viewModel::onEvent,
                onReadFullStoryButtonClick = { url ->
                    navController.navigate("${Screen.ArticleScreen.route}?web_url=$url")
                }
            )
        }
        composable(
            "${Screen.ArticleScreen.route}?web_url={web_url}",
            arguments = listOf(navArgument(name = "web_url") {
                type = NavType.StringType
            }
            )
        ) { backStactEntry ->
            ArticleScreen(
                url = backStactEntry.arguments?.getString("web_url"),
                onBackPressed = {
                    navController.navigateUp()
                }
            )
        }
    }

}