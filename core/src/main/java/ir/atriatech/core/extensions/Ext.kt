package ir.atriatech.core.extensions

import android.app.Application

object Ext {
	lateinit var ctx: Application

	fun with(app: Application) {
		ctx = app
	}
}