package ir.meysamd.withhossein.app.login

import io.reactivex.disposables.CompositeDisposable
import ir.meysamd.withhossein.core.common.data.remote.RequestService
import ir.atriatech.core.entities.ServerErrorObject
import ir.meysamd.withhossein.core.repository.BaseRepository
import javax.inject.Inject

class LoginRepository @Inject constructor(val requestService: RequestService) : BaseRepository() {
	var msgOutcome = outCome<ServerErrorObject>()

	fun login(mobile: String, bag: CompositeDisposable) {
		requestToNetwork(msgOutcome, requestService.login(mobile), bag)
	}
}