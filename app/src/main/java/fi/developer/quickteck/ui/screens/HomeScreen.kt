package fi.developer.quickteck.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import fi.developer.quickteck.ui.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Text("Home Screen")
        Button(onClick = { navController.navigate(Screen.Profile.route) }) {
            Text("Go to Profile")
        }
        Button(onClick = { navController.navigate(Screen.Settings.route) }) {
            Text("Go to Settings")
        }

        Button(onClick = { navController.navigate(Screen.ButtonScreen.route) }) {
            Text("Go to Button")
        }
    }
}