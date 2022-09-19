package com.ppizil.cooflix.movielist.holder

import com.bumptech.glide.RequestManager
import com.ppizil.cooflix.base.BaseListAdapter
import com.ppizil.cooflix.databinding.ItemMovieCategorySectionBinding
import com.ppizil.presentaion.model.movielist.MovieCategoryModel

class MovieCategoryHolder(
    private val binding: ItemMovieCategorySectionBinding,
    private val requestManager: RequestManager
) : BaseListAdapter<MovieCategoryModel>(binding) {
    override fun bind(item: MovieCategoryModel) {
        binding.item = item
        binding.requestManager = requestManager
        binding.executePendingBindings()
    }

    override fun recycled() {
        binding.reyclerview.adapter = null
    }

}