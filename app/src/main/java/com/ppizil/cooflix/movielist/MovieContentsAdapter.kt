package com.ppizil.cooflix.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.ppizil.cooflix.base.BaseListAdapter
import com.ppizil.cooflix.databinding.ItemMovieContentsBinding
import com.ppizil.cooflix.movielist.holder.MovieContentsHolder
import com.ppizil.presentaion.model.movielist.ViewMovieModel

class MovieContentsAdapter(
    private val requestManager: RequestManager
) : ListAdapter<ViewMovieModel, BaseListAdapter<ViewMovieModel>>(diffUtils) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseListAdapter<ViewMovieModel> =
        MovieContentsHolder(
            ItemMovieContentsBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            requestManager
        )


    override fun onBindViewHolder(holder: BaseListAdapter<ViewMovieModel>, position: Int) {
        holder.bind(getItem(position))
    }


    companion object {

        val diffUtils = object :
            DiffUtil.ItemCallback<ViewMovieModel>() {
            override fun areItemsTheSame(
                oldItem: ViewMovieModel,
                newItem: ViewMovieModel
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ViewMovieModel,
                newItem: ViewMovieModel
            ): Boolean =
                oldItem == newItem
        }
    }
}