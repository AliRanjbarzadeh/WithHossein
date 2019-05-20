package ir.meysamd.withhossein.app.login.mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import ir.atriatech.core.extensions.afterTextChanged
import ir.atriatech.core.extensions.openKeyboard
import ir.meysamd.withhossein.R
import ir.meysamd.withhossein.core.BaseFragment
import ir.meysamd.withhossein.databinding.FragmentMobileBinding

class MobileFragment : BaseFragment(), View.OnClickListener {

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

		return viewDataBinding.root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		viewDataBinding.etxMobile.run {
			afterTextChanged {
				mViewModel.mobile = it
			}
			requestFocus()
			openKeyboard(this)
		}

		viewDataBinding.btnLogin.run {
			setOnClickListener(this@MobileFragment)
		}
	}

	override fun onClick(v: View?) {
		when (v) {
			viewDataBinding.btnLogin -> {
				mViewModel.login()
			}
		}
	}

	private fun setupErrors() {
		mViewModel.run {
			empty = getString(R.string.mobile_empty)
			notValid = getString(R.string.mobile_not_valid)
		}
	}
}