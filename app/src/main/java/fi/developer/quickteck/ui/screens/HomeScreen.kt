package fi.developer.quickteck.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import fi.developer.quickteck.ui.theme.Nunito

@Composable
fun HomeScreen(
    navigationDrawer: () -> Unit,
    onGoToProfile: () -> Unit,
    onGoToSettings: () -> Unit,
    onGoToButtonScreen: () -> Unit,
    homeScreenViewModel: HomeScreenViewModel = viewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            IconButton(onClick = navigationDrawer) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Back")
            }
            Text(
                "Home Screen",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp),
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = Nunito,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Home Screen second raw", modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp),
                color = Color.Black,
                fontSize = 15.sp,
                fontFamily = Nunito,
                fontWeight = FontWeight.Medium
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onGoToProfile) {
                Text("Profile")
            }
            Button(onClick = onGoToSettings) {
                Text("Settings")
            }
            Button(onClick = onGoToButtonScreen) {
                Text("Buttons")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(navigationDrawer = {}, onGoToProfile = {}, onGoToSettings = {}, onGoToButtonScreen = {})
}