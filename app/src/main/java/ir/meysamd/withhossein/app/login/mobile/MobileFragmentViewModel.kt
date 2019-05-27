package ir.meysamd.withhossein.app.login.mobile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.atriatech.core.entities.Msg
import ir.atriatech.core.extensions.toEn
import ir.atriatech.core.extensions.toLiveData
import ir.atriatech.core.extensions.validMobile
import ir.atriatech.core.networking.Outcome
import ir.meysamd.withhossein.app.login.LoginRepository
import ir.meysamd.withhossein.core.BaseFragmentViewModel
import values.eToast
import javax.inject.Inject

class MobileFragmentViewModel : BaseFragmentViewModel() {
	@Inject
	lateinit var loginRepository: LoginRepository

	private val _dataLoading = MutableLiveData<Boolean>()
	val dataLoading: LiveData<Boolean>
		get() = _dataLoading

	var mobile = ""

	var empty = ""
	var notValid = ""

	val msg: LiveData<Outcome<Msg>> by lazy { loginRepository.msgOutcome.toLiveData(bag) }

	init {
		component.inject(this)
	}

	fun login(): Boolean {
		if (mobile.isEmpty()) {
			eToast(empty)
			return false
		}

		if (!mobile.validMobile()) {
			eToast(notValid)
			return false
		}

		loginRepository.login(mobile.toEn(), bag)
		return true
	}
}