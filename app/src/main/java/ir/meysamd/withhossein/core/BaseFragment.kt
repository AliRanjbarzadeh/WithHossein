package ir.meysamd.withhossein.core

import android.content.Context
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import ir.atriatech.core.extensions.closeKeyboard
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener

open class BaseFragment : Fragment(), KeyboardVisibilityEventListener {

	override fun onAttach(context: Context) {
		super.onAttach(context)

		KeyboardVisibilityEvent.setEventListener(
			activity,
			this
		)
	}

	override fun onVisibilityChanged(isOpen: Boolean) {
	}

	protected fun initBase(mParentView: View?) {

		//parent view click to hide keyboard
		mParentView?.run {
			setOnTouchListener { v, event ->
				when (event.action) {
					MotionEvent.ACTION_DOWN -> closeKeyboard()

					MotionEvent.ACTION_UP -> {
						if (event.eventTime - event.downTime < 200) {
							v?.performClick()
						}
					}
				}
				true
			}
		}
	}
}