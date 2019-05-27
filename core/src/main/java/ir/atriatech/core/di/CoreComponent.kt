package ir.atriatech.core.di

import android.content.Context
import com.google.gson.Gson
import dagger.Component
import ir.atriatech.core.networking.Scheduler
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface CoreComponent {
	fun context(): Context

	fun retrofit(): Retrofit

	fun scheduler(): Scheduler

	fun gson(): Gson
}