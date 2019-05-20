package ir.meysamd.withhossein.core.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import ir.meysamd.withhossein.core.common.data.remote.RequestService
import retrofit2.Retrofit

@Module
class BaseAppModule {
	//Composite disposable
	@Provides
	@BaseAppScope
	fun compositeDisposable(): CompositeDisposable = CompositeDisposable()


	//Request service
	@Provides
	@BaseAppScope
	fun publicRequestService(retrofit: Retrofit)
			: RequestService = retrofit.create(RequestService::class.java)
}