package ir.meysamd.withhossein.app.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import ir.meysamd.withhossein.R
import ir.meysamd.withhossein.core.BaseFragment
import ir.meysamd.withhossein.databinding.FragmentMobileBinding
import kotlinx.android.synthetic.main.fragment_mobile.*

class MobileFragment : BaseFragment() {

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
    }
}