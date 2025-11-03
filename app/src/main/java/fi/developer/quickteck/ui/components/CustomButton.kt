package fi.developer.quickteck.ui.components

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun FilledButtonShape(onClick: () -> Unit) {
    FilledTonalButton(onClick = {onClick()}) {
        Text(text = "Filled Tonal Button")
    }
}

@Composable
fun OutlinedButtonShape(onClick: () -> Unit) {
    OutlinedButton(onClick = {onClick()}) {
        Text(text = "Outlined Button")
    }
}

@Composable
fun ElevatedButtonShape(onClick: () -> Unit) {
    ElevatedButton(onClick = {onClick()}) {
        Text(text = "Elevated Button")
    }
}

@Composable
fun TextButtonShape( onClick: () -> Unit) {
    TextButton(onClick = {onClick()}) {
        Text(text = "Text Button")
    }
}