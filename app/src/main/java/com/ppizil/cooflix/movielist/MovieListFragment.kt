package com.ppizil.cooflix.movielist

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.ppizil.cooflix.base.BaseFragment
import com.ppizil.cooflix.R
import com.ppizil.cooflix.databinding.FragmentMovieListBinding
import com.ppizil.cooflix.utils.repeatOnStarted
import com.ppizil.presentaion.movielist.MovieListState
import com.ppizil.presentaion.movielist.MovieListVm
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment :
    BaseFragment<FragmentMovieListBinding, MovieListState>(R.layout.fragment_movie_list) {

    private val viewModel: MovieListVm by viewModels()
    private val requestManager: RequestManager by lazy {
        Glide.with(requireActivity())
    }
    private val horAdapter: MovieCategoryAdapter by lazy {
        MovieCategoryAdapter(requestManager)
    }

    override fun setupBinding() {
        binding.viewModel = viewModel
        binding.adapter = horAdapter
    }

    override fun setupObserving() {
        repeatOnStarted {
            viewModel.uiState.collect {
                it?.let {
                    handleEvent(it)
                }
            }
        }
    }

    override fun setData() {
        viewModel.fetchMoveiList()
    }

    override fun handleEvent(state: MovieListState) {
        when (state) {
            MovieListState.Dismiss -> findNavController().navigateUp()
            is MovieListState.Success ->{
                horAdapter.submitList(state.movies)
            }
        }
    }
}