package fi.developer.quickteck.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.asSharedFlow

class ButtonScreenViewModel: ViewModel() {
    private val _toastMessages = MutableSharedFlow<String>()
    val toastMessages = _toastMessages.asSharedFlow()

    fun onButtonClicked(buttonName: String) {
        val message = "Button $buttonName clicked"
        Log.d("QuickButtonScreenViewModel", message)
        viewModelScope.launch {
            _toastMessages.emit(message)
        }
    }
}