package ir.atriatech.core.extensions

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import java.util.*

@Suppress("DEPRECATION")
fun AppCompatActivity.setLanguage(language: String) {
	val locale = Locale(language)
	Locale.setDefault(locale)

	val resources = this.applicationContext.resources
	val configuration = resources.configuration
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
		configuration.setLocale(locale)
	else
		configuration.locale = locale

	configuration.setLayoutDirection(locale)
	this.resources.updateConfiguration(configuration, this.applicationContext.resources.displayMetrics)
	resources.updateConfiguration(configuration, this.applicationContext.resources.displayMetrics)

	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
		this.applicationContext.createConfigurationContext(configuration)
}

@Suppress("DEPRECATION")
fun AppCompatActivity.setLanguage(context: Context, language: String) {
	val locale = Locale(language)
	Locale.setDefault(locale)

	val resources = context.resources
	val configuration = resources.configuration
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
		configuration.setLocale(locale)
	else
		configuration.locale = locale

	configuration.setLayoutDirection(locale)
	resources.updateConfiguration(configuration, resources.displayMetrics)

	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
		context.createConfigurationContext(configuration)
}

/*========================Keyboard==============================*/
fun AppCompatActivity.closeKeyboard() {
	val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
	if (inputMethodManager.isAcceptingText) {
		if (currentFocus != null) {
			inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
		}
	}
}

fun AppCompatActivity.openKeyboard(view: View) {
	val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
	inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}