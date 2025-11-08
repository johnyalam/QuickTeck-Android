package fi.developer.quickteck.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fi.developer.quickteck.ui.screens.ButtonScreen
import fi.developer.quickteck.ui.screens.HomeScreen
import fi.developer.quickteck.ui.screens.ProfileScreen
import fi.developer.quickteck.ui.screens.SettingsScreen

@Composable
fun AppNavGraph(navController: NavHostController, openNavigationDrawer: () -> Unit) {

    NavHost(navController, Screen.Home.route) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigationDrawer =  openNavigationDrawer,
                    onGoToProfile = { navController.navigate(Screen.Profile.route) },
                    onGoToSettings = { navController.navigate(Screen.Settings.route) },
                    onGoToButtonScreen = { navController.navigate(Screen.ButtonScreen.route) }
                )
            }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.ButtonScreen.route) { ButtonScreen(navController) }
    }
}