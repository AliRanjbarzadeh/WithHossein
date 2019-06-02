package ir.meysamd.withhossein.app.login.mobile

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import ir.atriatech.core.extensions.closeKeyboard
import ir.atriatech.core.extensions.openKeyboard
import ir.meysamd.withhossein.R
import ir.meysamd.withhossein.core.BaseFragment
import ir.meysamd.withhossein.databinding.FragmentMobileBinding

class MobileFragment : BaseFragment() {

	private lateinit var viewDataBinding: FragmentMobileBinding

	private val mViewModel by lazy { ViewModelProviders.of(this).get(MobileFragmentViewModel::class.java) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setupErrors()
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		if (container == null) {
			return null
		}

		viewDataBinding = FragmentMobileBinding.inflate(inflater, container, false).apply {
			viewModel = mViewModel
		}

		initBase(mParentView = viewDataBinding.mParentView)

		return viewDataBinding.root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		viewDataBinding.etxMobile.run {
			setOnEditorActionListener { _, actionId, _ ->
				when (actionId) {
					EditorInfo.IME_ACTION_DONE -> viewDataBinding.btnLogin.performClick()
				}
				true
			}
			requestFocus()
			openKeyboard(this)
		}

		viewDataBinding.btnLogin.run {
			setOnClickListener {
				if (!mViewModel.login()) {
					viewDataBinding.etxMobile.requestFocus()
					openKeyboard(viewDataBinding.etxMobile)
				} else {
					closeKeyboard()
					Handler().postDelayed({
						mViewModel.stopLoading()

						val extras = FragmentNavigatorExtras(
							viewDataBinding.btnLogin to "mButton"
						)
						findNavController().navigate(R.id.verifyFragment, null, null, extras)
					}, 3000)
				}

			}
		}
	}

	override fun onVisibilityChanged(isOpen: Boolean) {
		when (isOpen) {
			false -> {
				viewDataBinding.etxMobile.clearFocus()
			}
		}
	}

	/*===============My methods===============*/
	private fun setupErrors() {
		mViewModel.run {
			empty = getString(R.string.mobile_empty)
			notValid = getString(R.string.mobile_not_valid)
		}
	}
}