package ir.atriatech.core.extensions

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import ir.atriatech.core.constants.DEFAULT_ERROR
import ir.atriatech.core.entities.Msg

fun HttpException.getServerErrorMessage(): String {
	var errorMessage = DEFAULT_ERROR
	try {
		val gson = Gson()
		val json = response().errorBody()?.string()
		val error = gson.fromJson(json, Msg::class.java)
		e(error.msg)
		errorMessage = error.msg

	} catch (e: Exception) {
		//Network error
		e(errorMessage)
	} finally {
		return errorMessage
	}
}

fun retrofit2.HttpException.getServerErrorMessage(): String {
	var errorMessage = DEFAULT_ERROR
	try {
		val gson = Gson()
		val json = response().errorBody()?.string()
		val error = gson.fromJson(json, Msg::class.java)
		e(error.msg)
		errorMessage = error.msg

	} catch (e: Exception) {
		//Network error
		e(errorMessage)
	} finally {
		return errorMessage
	}
}

fun Throwable.getDefaultErrorMessage(): String {
	val errorMessage = DEFAULT_ERROR
	this.printStackTrace()
	e(this.message)
	return errorMessage
}