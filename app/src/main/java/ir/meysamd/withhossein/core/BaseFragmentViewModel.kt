package ir.meysamd.withhossein.core

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.meysamd.withhossein.core.common.AppDH

abstract class BaseFragmentViewModel : ViewModel() {
	open val component by lazy { AppDH.baseComponent() }

	val bag = CompositeDisposable()

	override fun onCleared() {
		super.onCleared()
		bag.clear()
	}
}