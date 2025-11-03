package fi.developer.quickteck

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fi.developer.quickteck.ui.components.showToast
import fi.developer.quickteck.ui.screens.ButtonScreen
import fi.developer.quickteck.ui.screens.ButtonScreenViewModel
import fi.developer.quickteck.ui.theme.QuickTeckTheme
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    private val viewModel = ButtonScreenViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickTeckTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LaunchedEffect(Unit ) {
                        viewModel.toastMessages.collectLatest { message ->
                            Log.d("QuickMainActivity", message)
                            showToast(this@MainActivity, message)
                        }
                    }

                    ButtonScreen(
                        paddingValues = innerPadding,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonListScreenPreview() {
    QuickTeckTheme {
        ButtonScreen( paddingValues = PaddingValues(10.dp))
    }
}