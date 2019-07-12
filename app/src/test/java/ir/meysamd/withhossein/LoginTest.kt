package ir.meysamd.withhossein

import org.junit.Test

class LoginTest {
	@Test
	fun checkMobile() {
		assert("09176776315".matches("09\\d{9}".toRegex()))
	}
}