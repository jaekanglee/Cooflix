package presentation.main.item.group

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hjiee.presentation.databinding.ItemGroupMovieBinding
import presentation.main.item.movie.MovieItemModel
import presentation.main.item.movie.MovieListAdapter

class MovieGroupListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: ItemGroupMovieBinding? = DataBindingUtil.bind(itemView)
    private val listAdapter = MovieListAdapter()

    fun onBind(itemModel: MovieGroupListModel, position: Int) {
        binding?.run {
            if (group != itemModel) {
                group = itemModel
                rvMovieGroup.adapter = listAdapter
                setData(itemModel.movieList)
            }
            executePendingBindings()
        }
    }

    private fun setData(list: List<MovieItemModel>) {
        listAdapter.addAll(list)
    }
}