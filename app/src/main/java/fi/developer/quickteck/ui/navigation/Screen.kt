package fi.developer.quickteck.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
    data object ButtonScreen : Screen("buttonScreen")
}

enum class Menus(
    val title: String,
    val route: String
) {
    Home("Home", Screen.Home.route),
    Profile("Profile", Screen.Profile.route),
    Settings("Settings", Screen.Settings.route),
    Buttons("Buttons", Screen.ButtonScreen.route)
}