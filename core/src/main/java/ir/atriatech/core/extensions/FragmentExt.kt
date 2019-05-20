package ir.atriatech.core.extensions

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.setLanguage(language: String) {
	(activity as AppCompatActivity).setLanguage(language)
}

/*========================Keyboard==============================*/
fun Fragment.closeKeyboard() {
	(activity as AppCompatActivity).closeKeyboard()
}

fun Fragment.openKeyboard(view: View) {
	(activity as AppCompatActivity).openKeyboard(view)
}