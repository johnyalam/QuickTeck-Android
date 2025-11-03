package fi.developer.quickteck.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
    data object ButtonScreen : Screen("buttonScreen")
}