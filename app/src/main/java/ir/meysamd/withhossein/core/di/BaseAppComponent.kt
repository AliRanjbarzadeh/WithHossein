package ir.meysamd.withhossein.core.di

import android.content.Context
import com.google.gson.Gson
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import ir.atriatech.core.di.CoreComponent
import ir.meysamd.withhossein.core.common.data.remote.RequestService
import retrofit2.Retrofit

@BaseAppScope
@Component(dependencies = [CoreComponent::class], modules = [BaseAppModule::class])
interface BaseAppComponent {

	fun context(): Context

	fun retrofit(): Retrofit

	fun gson(): Gson

	fun compositeDisposable(): CompositeDisposable

	fun requestService(): RequestService
}