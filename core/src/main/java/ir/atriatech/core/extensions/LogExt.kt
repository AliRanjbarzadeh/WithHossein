package ir.atriatech.core.extensions

import ir.atriatech.core.BuildConfig
import timber.log.Timber

fun e(msg: Any?, tag: String = BuildConfig.PROJECT_NAME) {
	if (msg == null) {
		Timber.tag(tag).e("Your Object Is null !!!")
	} else {
		Timber.tag(tag).e(msg.toString())
	}
}

fun d(msg: Any?, tag: String = BuildConfig.PROJECT_NAME) {
	if (msg == null) {
		Timber.tag(tag).d("Your Object Is null !!!")
	} else {
		Timber.tag(tag).d(msg.toString())
	}
}
