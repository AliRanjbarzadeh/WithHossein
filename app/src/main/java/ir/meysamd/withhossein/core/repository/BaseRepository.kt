package ir.meysamd.withhossein.core.repository

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import ir.atriatech.core.extensions.*
import ir.atriatech.core.networking.Outcome
import ir.meysamd.withhossein.core.BAD_REQUEST
import ir.meysamd.withhossein.core.UNAUTHORIZED

open class BaseRepository {
	fun <T> requestToNetwork(subject: PublishSubject<Outcome<T>>, single: Single<T>, disposable: CompositeDisposable) {
		subject.loading(true)
		single.performOnBackOutOnMain()
			.subscribe({
				subject.success(it)
			}, {
				when (it) {
					is HttpException -> {
						when (it.code()) {
							BAD_REQUEST -> subject.serverError(it)

							UNAUTHORIZED -> subject.unauthorized(true)

							else -> subject.failed(it)
						}
					}

					else -> subject.failed(it)
				}
			}).addTo(disposable)
	}

	fun <T> outCome(): PublishSubject<Outcome<T>> {
		return PublishSubject.create<Outcome<T>>()
	}
}