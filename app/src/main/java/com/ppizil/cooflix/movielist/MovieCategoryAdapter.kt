package com.ppizil.cooflix.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.ppizil.cooflix.databinding.ItemMovieCategorySectionBinding
import com.ppizil.cooflix.movielist.holder.MovieCategoryHolder
import com.ppizil.presentaion.model.movielist.MovieCategoryModel

class MovieCategoryAdapter(
    private val requestManager: RequestManager
) : ListAdapter<MovieCategoryModel, MovieCategoryHolder>(diffutils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCategoryHolder =
        MovieCategoryHolder(
            ItemMovieCategorySectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            requestManager
        )

    override fun onBindViewHolder(holder: MovieCategoryHolder, position: Int) {
        holder.bind(getItem(position))
    }


    companion object {
        val diffutils = object :
            DiffUtil.ItemCallback<MovieCategoryModel>() {
            override fun areItemsTheSame(
                oldItem: MovieCategoryModel,
                newItem: MovieCategoryModel
            ): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: MovieCategoryModel,
                newItem: MovieCategoryModel
            ): Boolean =
                oldItem == newItem
        }
    }
}