package ir.atriatech.core.extensions

import android.annotation.SuppressLint
import android.widget.Toast
import com.muddzdev.styleabletoast.StyleableToast
import ir.atriatech.core.R

private var toast: Toast? = null

@SuppressLint("ShowToast")
fun toast(msg: Any?, isShort: Boolean = true) {
	msg?.let {
		if (toast == null) {
			toast = Toast.makeText(app, msg.toString(), Toast.LENGTH_SHORT)
		} else {
			toast!!.setText(msg.toString())
		}
		toast!!.duration = if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
		toast!!.show()
	}
}

fun eToast(msg: Any?) {
	StyleableToast.makeText(app, msg.toString(), Toast.LENGTH_LONG, R.style.eToast).show()
}

fun sToast(msg: Any?) {
	StyleableToast.makeText(app, msg.toString(), Toast.LENGTH_LONG, R.style.sToast).show()
}

fun infoToast(msg: Any?) {
	StyleableToast.makeText(app, msg.toString(), Toast.LENGTH_LONG, R.style.infoToast).show()
}

fun allDoneToast(msg: Any?) {
	StyleableToast.makeText(app, msg.toString(), Toast.LENGTH_LONG, R.style.allDoneToast).show()
}