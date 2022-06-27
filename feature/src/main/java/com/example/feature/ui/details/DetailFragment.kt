package com.example.feature.ui.details

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.base.BaseFragment
import com.example.feature.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


/**
 * Detail Fragment
 */
@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {



    private val args : DetailFragmentArgs by navArgs()


    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailBinding
        get() = FragmentDetailBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
        args.book?.let { book ->
            binding.book = book
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
    }

}