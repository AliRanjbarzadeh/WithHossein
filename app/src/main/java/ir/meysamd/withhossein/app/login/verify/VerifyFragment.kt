package ir.meysamd.withhossein.app.login.verify

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionInflater
import ir.meysamd.withhossein.R
import ir.meysamd.withhossein.core.BaseFragment
import ir.meysamd.withhossein.databinding.FragmentVerifyBinding

class VerifyFragment : BaseFragment() {

	private lateinit var viewDataBinding: FragmentVerifyBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
		}
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		if (container == null) {
			return null
		}

		viewDataBinding = FragmentVerifyBinding.inflate(inflater, container, false).apply {
		}

		viewDataBinding.mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
		viewDataBinding.mToolbar.setNavigationOnClickListener {
			activity?.onBackPressed()
		}
		return viewDataBinding.root
	}
}