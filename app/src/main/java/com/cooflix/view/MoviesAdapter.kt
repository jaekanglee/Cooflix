package com.cooflix.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cooflix.databinding.ViewMovieBinding
import com.cooplix.model.Movie

class MoviesAdapter: ListAdapter<Movie, MoviesAdapter.MovieViewHolder>(
    object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

    }
) {

    class MovieViewHolder(private val viewBinding: ViewMovieBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(movie: Movie) {
            viewBinding.titleTextView.text = movie.title
            Glide.with(viewBinding.root).load(movie.posterPath).into(viewBinding.posterImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ViewMovieBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}