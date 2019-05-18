package ir.meysamd.withhossein.app.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.layoutDirection
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import ir.meysamd.withhossein.R
import ir.meysamd.withhossein.app.MainActivity
import ir.meysamd.withhossein.core.BaseFragment
import ir.meysamd.withhossein.core.common.AppDH
import ir.meysamd.withhossein.databinding.FragmentMobileBinding
import kotlinx.android.synthetic.main.fragment_mobile.*
import java.util.*
import javax.inject.Inject

class MobileFragment : BaseFragment() {

	//region Dagger
	private val component by lazy { AppDH.baseComponent() }

	@Inject
	lateinit var mContext: Context
	//endregion

	override fun onAttach(context: Context) {
		super.onAttach(context)
		component.inject(this)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		if (container == null) {
			return null
		}

		val binding = DataBindingUtil.inflate<FragmentMobileBinding>(
			inflater,
			R.layout.fragment_mobile, container, false
		)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		mButton.setOnClickListener {
			val extras = FragmentNavigatorExtras(
				mButton to "mButton",
				mTitle to "mTitle"
			)
			findNavController().navigate(R.id.verifyFragment, null, null, extras)
		}

		fabLanguage.setOnClickListener {
			(activity as MainActivity).changeLanguage("fa")
			val extras = FragmentNavigatorExtras(
				mButton to "mButton",
				mTitle to "mTitle"
			)
			findNavController().navigate(R.id.verifyFragment, null, null, extras)
		}
	}
}