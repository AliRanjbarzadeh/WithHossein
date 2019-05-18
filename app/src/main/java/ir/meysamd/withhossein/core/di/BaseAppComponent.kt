package ir.meysamd.withhossein.core.di

import android.content.Context
import dagger.Component
import ir.atriatech.core.di.CoreComponent
import ir.meysamd.withhossein.app.MainActivity

@BaseAppScope
@Component(dependencies = [CoreComponent::class], modules = [BaseAppModule::class])
interface BaseAppComponent {

	fun context(): Context
}