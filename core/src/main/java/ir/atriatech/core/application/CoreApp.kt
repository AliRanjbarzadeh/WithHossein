package ir.atriatech.core.application

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.orhanobut.logger.Logger
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import ir.atriatech.core.BuildConfig
import ir.atriatech.core.R
import ir.atriatech.core.constants.Constants
import ir.atriatech.core.di.AppModule
import ir.atriatech.core.di.CoreComponent
import ir.atriatech.core.di.DaggerCoreComponent
import java.util.*

open class CoreApp : Application() {

	companion object {
		lateinit var coreComponent: CoreComponent
	}

	override fun attachBaseContext(base: Context?) {
		super.attachBaseContext(base)
		MultiDex.install(this)
	}

	override fun onCreate() {
		super.onCreate()
		initDI()
		initStetho()
//		initFont(
//			initLocale(
//				coreComponent.sharedPreferences().getString(
//					Constants.LANGUAGE_SESSION_KEY,
//					Constants.DEFAULT_LANGUAGE
//				)!!
//			)
//		)
	}

	private fun initStetho() {
		if (BuildConfig.DEBUG)
			Stetho.initializeWithDefaults(this)
	}

	private fun initDI() {
		coreComponent = DaggerCoreComponent.builder().appModule(AppModule(this)).build()
	}

	private fun initLocale(language: String): Context {
		val configuration = resources.configuration
		val locale = Locale(language)
		Locale.setDefault(locale)
		configuration.setLocale(locale)
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			val localList = LocaleList(locale)
			LocaleList.setDefault(localList)
			configuration.locales = localList
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			configuration.setLocale(locale)
		}
		return createConfigurationContext(configuration)
	}


	private fun initFont(mContext: Context) {

		val fontPath = mContext.getString(R.string.AppFont)
		Logger.d(fontPath)

		Logger.d(fontPath)
		ViewPump.init(
			ViewPump.builder()
				.addInterceptor(
					CalligraphyInterceptor(
						CalligraphyConfig.Builder()
							.setDefaultFontPath(fontPath)
							.setFontAttrId(R.attr.fontPath)
							.build()
					)
				).build()
		)
	}

}