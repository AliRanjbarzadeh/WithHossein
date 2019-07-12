package ir.atriatech.core.extensions

import androidx.annotation.NonNull
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import ir.atriatech.core.entities.ServerErrorObject
import ir.atriatech.core.networking.Outcome

interface LiveResult<T> {
	fun onProgress(loading: Boolean)
	fun onFailure(e: Throwable)
	fun onSuccess(data: T)
	fun onServerError(serverErrorObject: ServerErrorObject)
	fun onUnauthorized()
}

fun <T> LiveData<Outcome<T>>.observeOutCome(@NonNull owner: LifecycleOwner, @NonNull liveResult: LiveResult<T>) {
	observe(owner, Observer { outcome ->
		when (outcome) {
			is Outcome.Progress -> liveResult.onProgress(outcome.loading)

			is Outcome.Success -> liveResult.onSuccess(outcome.data)

			is Outcome.Failure -> liveResult.onFailure(outcome.e)

			is Outcome.ServerError -> liveResult.onServerError(outcome.httpException.getServerErrorObject())

			is Outcome.Unauthorized -> {
				liveResult.onUnauthorized()
				//TODO: delete all shared prefs
			}
		}
	})
}