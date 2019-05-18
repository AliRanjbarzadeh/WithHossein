package ir.meysamd.withhossein.core

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

	abstract fun changeLanguage(language: String)

	protected fun setLanguage(context: Context, language: String) {
		updateResources(context, language)
	}

	@Suppress("DEPRECATION")
	private fun updateResources(context: Context, language: String) {
		val locale = Locale(language)
		Locale.setDefault(locale)

		val resources = context.resources
		val configuration = resources.configuration
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
			configuration.setLocale(locale)
		else
			configuration.locale = locale

		configuration.setLayoutDirection(locale)
		this.resources.updateConfiguration(configuration, context.resources.displayMetrics)
		resources.updateConfiguration(configuration, context.resources.displayMetrics)

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
			context.createConfigurationContext(configuration)
	}
}