package ir.atriatech.core.extensions

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import ir.atriatech.core.application.BaseMutableLiveData
import ir.atriatech.core.networking.Outcome

/**
 * Extension function to convert a Publish subject into a LiveData by subscribing to it.
 **/
fun <T> PublishSubject<T>.toLiveData(compositeDisposable: CompositeDisposable): BaseMutableLiveData<T> {
	val data = BaseMutableLiveData<T>()
	data.disposable = this.subscribe { t: T -> data.value = t }
	compositeDisposable.add(data.disposable!!)
	return data
}

fun <T> PublishSubject<T>.refreshLiveData(compositeDisposable: CompositeDisposable, data: BaseMutableLiveData<T>) {
	data.disposable = this.subscribe { t: T -> data.value = t }
	compositeDisposable.add(data.disposable!!)
}

/**
 * Extension function to push a httpException to the observing outcome
 * */
fun <T> PublishSubject<Outcome<T>>.serverError(serverError: HttpException) {
	with(this) {
		loading(false)
		onNext(Outcome.serverError(serverError))
	}
}

/**
 * Extension function to push a unauthorized to the observing outcome
 * */
fun <T> PublishSubject<Outcome<T>>.unauthorized(logout: Boolean = false) {
	with(this) {
		loading(false)
		onNext(Outcome.unauthorized(logout))
	}
}

/**
 * Extension function to push a failed event with an exception to the observing outcome
 * */
fun <T> PublishSubject<Outcome<T>>.failed(e: Throwable) {
	with(this) {
		loading(false)
		onNext(Outcome.failure(e))
	}
}

/**
 * Extension function to push  a success event with data to the observing outcome
 * */
fun <T> PublishSubject<Outcome<T>>.success(t: T) {
	with(this) {
		loading(false)
		onNext(Outcome.success(t))
	}
}

/**
 * Extension function to push the loading status to the observing outcome
 * */
fun <T> PublishSubject<Outcome<T>>.loading(isLoading: Boolean) {
	this.onNext(Outcome.loading(isLoading))
}