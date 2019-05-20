package ir.meysamd.withhossein.app.login

import io.reactivex.disposables.CompositeDisposable
import ir.meysamd.withhossein.core.common.data.remote.RequestService
import ir.atriatech.core.entities.Msg
import ir.meysamd.withhossein.core.repository.BaseRepository
import javax.inject.Inject

class LoginRepository @Inject constructor(val requestService: RequestService) : BaseRepository() {
	var msgOutcome = outCome<Msg>()

	fun login(mobile: String, bag: CompositeDisposable) {
		requestToNetwork(msgOutcome, requestService.login(mobile), bag)
	}
}