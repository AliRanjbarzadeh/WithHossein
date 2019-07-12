package ir.atriatech.core.extensions

import com.orhanobut.hawk.Hawk

fun <T> saveToSp(key: String, t: T) = Hawk.put(key, t)

fun <T> loadFromSp(key: String): T = Hawk.get(key)

@Suppress("UNCHECKED_CAST")
fun <T> loadFromSp(key: String, defaultValue: Any): T {
	return if (existInSp(key))
		Hawk.get(key)
	else
		defaultValue as T
}

fun existInSp(key: String): Boolean = Hawk.contains(key)

fun deleteAllInSp() = Hawk.deleteAll()




