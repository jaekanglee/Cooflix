package com.cooflix.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cooflix.databinding.ViewGenreMoviesBinding
import com.cooplix.model.GenreMovies

class MoviesGroupAdapter: ListAdapter<GenreMovies, MoviesGroupAdapter.MoviesGroupViewHolder>(
    object : DiffUtil.ItemCallback<GenreMovies>() {
        override fun areItemsTheSame(oldItem: GenreMovies, newItem: GenreMovies): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: GenreMovies, newItem: GenreMovies): Boolean {
            return oldItem.genre == newItem.genre
        }

    }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesGroupViewHolder {
        return MoviesGroupViewHolder(ViewGenreMoviesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MoviesGroupViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class MoviesGroupViewHolder(private val viewBinding: ViewGenreMoviesBinding): RecyclerView.ViewHolder(viewBinding.root) {
        private val moviesAdapter = MoviesAdapter()

        init {
            viewBinding.movieRecyclerView.adapter = moviesAdapter
        }

        fun onBind(genreMovies: GenreMovies) {
            viewBinding.genreTextView.text = genreMovies.genre.name
            moviesAdapter.submitList(genreMovies.movies)
        }
    }
}