package presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import presentation.ui.screens.TvShowDetailScreen
import presentation.ui.screens.TvShowListScreen

@Composable
fun TvShowNavGraph(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "list",
        modifier = modifier
    ) {
        composable("list") {
            TvShowListScreen(
                onItemClick = { permalink ->
                    navController.navigate("details/$permalink")
                }
            )
        }
        composable("details/{permalink}") { backStackEntry ->
            val permalink = backStackEntry.arguments?.getString("permalink") ?: return@composable
            TvShowDetailScreen(permalink = permalink)
        }
    }
}
