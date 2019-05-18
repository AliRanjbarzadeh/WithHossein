package ir.meysamd.withhossein.core.di

import dagger.Component
import ir.meysamd.withhossein.app.login.MobileFragment

@BaseScope
@Component(dependencies = [BaseAppComponent::class])
interface BaseComponent {
	fun inject(mobileFragment: MobileFragment)
}