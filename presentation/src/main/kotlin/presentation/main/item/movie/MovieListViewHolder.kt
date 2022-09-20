package presentation.main.item.movie

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hjiee.presentation.databinding.ItemMovieBinding

class MovieListViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private val binding: ItemMovieBinding? = DataBindingUtil.bind(itemView)

    fun onBind(itemModel: MovieItemModel, position: Int) {
        binding?.run {
            movie = itemModel
            executePendingBindings()
        }
    }
}