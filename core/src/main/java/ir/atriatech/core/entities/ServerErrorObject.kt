package ir.atriatech.core.entities

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import ir.atriatech.core.constants.DEFAULT_ERROR

data class ServerErrorObject(
	@SerializedName("type")
	val type: Int = 0, // 0: Normal - 1: Empty list - 2: Has extra json

	@SerializedName("msg")
	val msg: String = DEFAULT_ERROR,

	@SerializedName("extras")
	val extras: JsonElement? = null
)