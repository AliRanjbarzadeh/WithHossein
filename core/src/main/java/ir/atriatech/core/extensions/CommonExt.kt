package ir.atriatech.core.extensions

import android.app.Application

inline val app: Application
	get() = Ext.ctx