package fi.developer.quickteck.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fi.developer.quickteck.ui.screens.ButtonScreen
import fi.developer.quickteck.ui.screens.HomeScreen
import fi.developer.quickteck.ui.screens.ProfileScreen
import fi.developer.quickteck.ui.screens.SettingsScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController, Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.ButtonScreen.route) { ButtonScreen(navController) }
    }
}