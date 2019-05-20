package ir.atriatech.core.extensions

/**
 * Convert Persian numbers to English numbers
 */
fun String.toEn(): String {
	if (this.isEmpty())
		return this

	val chars = CharArray(this.length)
	for (i in 0 until this.length) {
		var ch = this[i]
		if (ch >= 0x0660.toChar() && ch <= 0x0669.toChar())
			ch -= 0x0660.toChar() - '0';
		else if (ch >= 0x06f0.toChar() && ch <= 0x06F9.toChar())
			ch -= 0x06f0.toChar() - '0';
		chars[i] = ch;
	}
	return String(chars)
}

/**
 * Check string is valid mobile
 */
fun String.validMobile(): Boolean = this.toEn().matches("09\\d{9}".toRegex())

/**
 * String validation for English or Number characters
 */
fun String.isEnglish(isName: Boolean): Boolean {
	var enRegex = "[a-zA-Z0-9]"
	if (!isName) {
		enRegex = "[a-zA-Z]"
	}
	for (ch in this.toEn().toCharArray()) {
		if (ch.toString().matches(enRegex.toRegex())) {
			return true
		}
	}
	return false
}