package ir.meysamd.withhossein.core.common.data.remote

import io.reactivex.Single
import ir.atriatech.core.entities.Msg
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RequestService {
	@FormUrlEncoded
	@POST("login")
	fun login(@Field("mobile") mobile: String): Single<Msg>
}