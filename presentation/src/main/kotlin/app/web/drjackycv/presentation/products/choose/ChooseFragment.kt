package app.web.drjackycv.presentation.products.choose

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import app.web.drjackycv.presentation.R
import app.web.drjackycv.presentation.databinding.FragmentChooseBinding
import app.web.drjackycv.presentation.extension.viewBinding

class ChooseFragment : Fragment(R.layout.fragment_choose) {

    private val binding by viewBinding(FragmentChooseBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val action =
            ChooseFragmentDirections.navigateToProductsListFragment()
        findNavController().navigate(action)
    }
}