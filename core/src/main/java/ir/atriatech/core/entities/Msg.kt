package ir.atriatech.core.entities

import com.google.gson.annotations.SerializedName

data class Msg(
	@SerializedName("msg")
	val msg: String
)