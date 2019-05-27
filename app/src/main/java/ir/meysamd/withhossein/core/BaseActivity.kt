package ir.meysamd.withhossein.core

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import ir.atriatech.core.extensions.setLanguage
import ir.meysamd.withhossein.core.common.MyAppObjects

abstract class BaseActivity : AppCompatActivity() {
	override fun attachBaseContext(newBase: Context) {
		setLanguage(newBase, MyAppObjects.language)
//		super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
		super.attachBaseContext(newBase)
	}

	override fun onResume() {
		super.onResume()

		//Update resources
//		setLanguage(MyAppObjects.language)
	}
}