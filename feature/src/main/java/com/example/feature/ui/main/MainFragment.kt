package com.example.feature.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.base.BaseFragment
import com.example.feature.databinding.FragmentMainBinding
import com.example.feature.ui.contract.MainContract
import com.example.feature.ui.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


/**
 * Main Fragment
 */
@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private val adapter: BooksAdapter by lazy {
        BooksAdapter { book ->
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(book)
            findNavController().navigate(action)
        }
    }

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
        binding.rvBooks.adapter = adapter
        initObservers()
    }



    /**
     * Initialize Observers
     */
    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {

                    when (val state = it.bookState) {
                        is MainContract.BooksState.Idle -> {
                            binding.loadingPb.isVisible = false
                        }
                        is MainContract.BooksState.Loading -> {
                            binding.loadingPb.isVisible = true
                        }
                        is MainContract.BooksState.Success -> {
                            val data = state.bookList
                            adapter.submitList(data)
                            binding.loadingPb.isVisible = false
                        }
                    }

                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect {
                    when (it) {
                        is MainContract.Effect.ShowError -> {
                            val msg = it.message
                            showErrorBanner(msg)

                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        //overcome memory leaks
        binding.rvBooks.adapter = null
        super.onDestroyView()
    }

}