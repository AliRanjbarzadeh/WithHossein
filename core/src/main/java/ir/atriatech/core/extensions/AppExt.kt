package ir.atriatech.core.extensions

import android.app.Application

@Suppress("DEPRECATION")
fun Application.setLanguage(language: String) {
	val locale = java.util.Locale(language)
	java.util.Locale.setDefault(locale)

	val resources = applicationContext.resources
	val configuration = resources.configuration
	if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
		configuration.setLocale(locale)
	else
		configuration.locale = locale

	configuration.setLayoutDirection(locale)
	resources.updateConfiguration(configuration, applicationContext.resources.displayMetrics)

	if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
		this.applicationContext.createConfigurationContext(configuration)
}