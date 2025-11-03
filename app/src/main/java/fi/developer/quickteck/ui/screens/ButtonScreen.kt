package fi.developer.quickteck.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import fi.developer.quickteck.MainActivity
import fi.developer.quickteck.ui.components.ElevatedButtonShape
import fi.developer.quickteck.ui.components.FilledButtonShape
import fi.developer.quickteck.ui.components.OutlinedButtonShape
import fi.developer.quickteck.ui.components.TextButtonShape
import fi.developer.quickteck.ui.components.showToast

@Composable
fun ButtonScreen(navController: NavController,
                 viewModel: ButtonScreenViewModel = ButtonScreenViewModel()) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.toastMessages.collect { message ->
            showToast(context as MainActivity, message)
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)) {

        FilledButtonShape(onClick = {viewModel.onButtonClicked( "Filled Button")})
        OutlinedButtonShape(onClick = {viewModel.onButtonClicked("Outlined Button")})
        ElevatedButtonShape(onClick = {viewModel.onButtonClicked("Elevated Button")})
        TextButtonShape(onClick = {viewModel.onButtonClicked( "Text Button")})

        Button(onClick = { navController.navigateUp() }) {
            Text("Go Back")
        }
    }
}