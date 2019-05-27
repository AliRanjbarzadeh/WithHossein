package ir.meysamd.withhossein.core

import ir.atriatech.core.application.CoreApp
import ir.atriatech.core.constants.Constants.DEFAULT_LANGUAGE
import ir.atriatech.core.constants.Constants.LANGUAGE_SESSION_KEY
import ir.atriatech.core.extensions.loadFromSp
import ir.meysamd.withhossein.core.common.MyAppObjects

class MyApp : CoreApp() {
	override fun onCreate() {
		super.onCreate()

		//Init language
		MyAppObjects.language = loadFromSp<String>(LANGUAGE_SESSION_KEY, DEFAULT_LANGUAGE)
	}
}