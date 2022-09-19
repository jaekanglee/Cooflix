package com.ppizil.cooflix.movielist.holder

import com.bumptech.glide.RequestManager
import com.ppizil.cooflix.base.BaseListAdapter
import com.ppizil.cooflix.databinding.ItemMovieContentsBinding
import com.ppizil.presentaion.movielist.ViewMovieModel

class MovieContentsHolder(
    private val binding: ItemMovieContentsBinding,
    private val requestManager: RequestManager
) : BaseListAdapter<ViewMovieModel>(binding) {
    override fun bind(item: ViewMovieModel) {
        binding.item = item
        binding.requestManager = requestManager
        binding.executePendingBindings()
    }

    override fun recycled() {
        requestManager.clear(binding.ivThumnail)
    }


}