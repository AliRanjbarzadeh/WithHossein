package ir.atriatech.core.networking

import ir.atriatech.core.constants.Constants.AUTHORIZATION
import ir.atriatech.core.constants.Constants.DEFAULT_LANGUAGE
import ir.atriatech.core.constants.Constants.DEFAULT_TOKEN
import ir.atriatech.core.constants.Constants.LANGUAGE_SESSION_KEY
import ir.atriatech.core.constants.Constants.TOKEN_PREFIX
import ir.atriatech.core.constants.Constants.TOKEN_SESSION_KEY
import ir.atriatech.core.extensions.loadFromSp
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class MyServiceInterceptor @Inject constructor() :
	Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response {
		val request = chain.request()
		val builder = request.newBuilder()

		val authorization = loadFromSp<String>(TOKEN_SESSION_KEY, DEFAULT_TOKEN)
		val language = loadFromSp<String>(LANGUAGE_SESSION_KEY, DEFAULT_LANGUAGE)

		builder.header("Cache-Control", "no-cache")
		builder.header("User-Agent", "WithHossein-Android-Application")
		builder.header("Language", language)
		builder.header("Device", "1")
		builder.header(AUTHORIZATION, TOKEN_PREFIX + authorization)

		return chain.proceed(builder.build())
	}
}