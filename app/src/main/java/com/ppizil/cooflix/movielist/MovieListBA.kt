package com.ppizil.cooflix.movielist

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.ppizil.presentaion.movielist.MovieCategories
import com.ppizil.presentaion.movielist.ViewMovieModel
import com.ppizil.presentaion.movielist.mapToStringType

@BindingAdapter("setImagePoster", "requestManager")
fun setImagePoster(imageView: AppCompatImageView, url: String?, requestManager: RequestManager?) {
    url ?: return
    requestManager ?: return

    requestManager
        .load("https://image.tmdb.org/t/p/w220_and_h330_face$url")
        .centerCrop()
        .into(imageView)
}


@BindingAdapter("setCategoryView")
fun setCategoryView(appCompatTextView: AppCompatTextView, category: MovieCategories?) {
    category ?: return
    appCompatTextView.text = category.mapToStringType()
}

@BindingAdapter("setHorizonMovieAdapter", "requestManager")
fun setHorizonMovieAdapter(
    recyclerView: RecyclerView,
    item: List<ViewMovieModel>?,
    requestManager: RequestManager?
) {
    item ?: return
    requestManager ?: return
    val adapter = MovieContentsAdapter(requestManager)


    recyclerView.layoutManager =
        LinearLayoutManager(recyclerView.context).apply {
            orientation = RecyclerView.HORIZONTAL
        }
    recyclerView.adapter = adapter

    adapter.submitList(item)
}