package fi.developer.quickteck.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fi.developer.quickteck.ui.components.ElevatedButtonShape
import fi.developer.quickteck.ui.components.FilledButtonShape
import fi.developer.quickteck.ui.components.OutlinedButtonShape
import fi.developer.quickteck.ui.components.TextButtonShape

@Composable
fun ButtonScreen(paddingValues: PaddingValues,
                 viewModel: ButtonScreenViewModel = ButtonScreenViewModel()) {
    Column(modifier = Modifier.fillMaxSize().padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)) {

        FilledButtonShape(onClick = {viewModel.onButtonClicked( "Filled Button")})
        OutlinedButtonShape(onClick = {viewModel.onButtonClicked("Outlined Button")})
        ElevatedButtonShape(onClick = {viewModel.onButtonClicked("Elevated Button")})
        TextButtonShape(onClick = {viewModel.onButtonClicked( "Text Button")})
    }
}