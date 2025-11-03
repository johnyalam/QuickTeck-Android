package fi.developer.quickteck.ui.components

import android.widget.Toast
import fi.developer.quickteck.MainActivity

fun showToast(activity: MainActivity, message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}