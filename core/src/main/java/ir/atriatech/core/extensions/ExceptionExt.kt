package ir.atriatech.core.extensions

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import ir.atriatech.core.entities.ServerErrorObject

fun HttpException.getServerErrorObject(): ServerErrorObject {
	var msg = ServerErrorObject()
	try {
		val gson = Gson()
		val json = response().errorBody()?.string()
		msg = gson.fromJson(json, ServerErrorObject::class.java)
		e(msg.msg)
	} catch (e: Exception) {
		//Network error
		e(e.message.toString())
	} finally {
		return msg
	}
}