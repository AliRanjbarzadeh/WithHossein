package ir.atriatech.core.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import ir.atriatech.core.BuildConfig
import ir.atriatech.core.R
import ir.atriatech.core.di.AppModule
import ir.atriatech.core.di.CoreComponent
import ir.atriatech.core.di.DaggerCoreComponent
import timber.log.Timber

open class CoreApp : Application() {

	companion object {
		lateinit var coreComponent: CoreComponent
	}

	override fun attachBaseContext(base: Context) {
		super.attachBaseContext(base)
		MultiDex.install(this)
	}

	override fun onCreate() {
		super.onCreate()
		initDI()
		initLogger()
		initTimber()
		initStetho()
		initFont(this)
	}

	private fun initDI() {
		coreComponent = DaggerCoreComponent.builder().appModule(AppModule(applicationContext)).build()
	}

	private fun initLogger() {
		val formatStrategy = PrettyFormatStrategy.newBuilder()
			.showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
			.methodCount(2)         // (Optional) How many method line to show. Default 2
			.methodOffset(2)        // (Optional) Hides internal method calls up to offset. Default 5
//           .logStrategy(Timber.asTree()) // (Optional) Changes the log strategy to print out. Default LogCat
			.tag("")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
			.build()

		Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {})
	}

	private fun initTimber() {
		Timber.plant(object : Timber.DebugTree() {
			override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
				Logger.log(priority, tag, message, t)
			}
		})
	}

	private fun initStetho() {
		if (BuildConfig.DEBUG)
			Stetho.initializeWithDefaults(this)
	}


	private fun initFont(mContext: Context) {

		val fontPath = mContext.getString(R.string.AppFont)
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