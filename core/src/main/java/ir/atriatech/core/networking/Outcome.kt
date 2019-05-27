package ir.atriatech.core.networking

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException

sealed class Outcome<T> {

	data class Progress<T>(var loading: Boolean) : Outcome<T>()
	data class Success<T>(var data: T) : Outcome<T>()
	data class Failure<T>(val e: Throwable) : Outcome<T>()
	data class ServerError<T>(val httpException: HttpException) : Outcome<T>()
	data class Unauthorized<T>(val logout: Boolean) : Outcome<T>()

	companion object {
		fun <T> loading(isLoading: Boolean): Outcome<T> = Progress(isLoading)

		fun <T> success(data: T): Outcome<T> = Success(data)

		fun <T> failure(e: Throwable): Outcome<T> = Failure(e)

		fun <T> serverError(httpException: HttpException): Outcome<T> = ServerError(httpException)

		fun <T> unauthorized(logout: Boolean): Outcome<T> = Unauthorized(logout)
	}
}