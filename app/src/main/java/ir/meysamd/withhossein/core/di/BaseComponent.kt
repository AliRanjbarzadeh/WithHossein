package ir.meysamd.withhossein.core.di

import dagger.Component
import ir.meysamd.withhossein.app.login.mobile.MobileFragmentViewModel

@BaseScope
@Component(dependencies = [BaseAppComponent::class])
interface BaseComponent {
	fun inject(mobileFragment: MobileFragmentViewModel)
}