package ir.meysamd.withhossein.core.common

import ir.atriatech.core.application.CoreApp
import ir.meysamd.withhossein.core.di.BaseAppComponent
import ir.meysamd.withhossein.core.di.BaseComponent
import ir.meysamd.withhossein.core.di.DaggerBaseAppComponent
import ir.meysamd.withhossein.core.di.DaggerBaseComponent

object AppDH {

	//region Base App Component
	private var baseApp: BaseAppComponent? = null

	fun baseAppComponent(): BaseAppComponent {
		if (baseApp == null)
			baseApp = DaggerBaseAppComponent.builder().coreComponent(CoreApp.coreComponent).build()

		return baseApp as BaseAppComponent
	}
	//endregion

	//region Base Component
	private var baseComponent: BaseComponent? = null

	fun baseComponent(): BaseComponent {
		if (baseComponent == null)
			baseComponent =
				DaggerBaseComponent.builder().baseAppComponent(baseAppComponent()).build()

		return baseComponent as BaseComponent
	}

	fun destroyBaseComponent() {
		baseComponent = null
	}
	//endregion
}