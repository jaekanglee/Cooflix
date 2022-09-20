package presentation.main.item.movie

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hjiee.presentation.R
import presentation.ext.createView

class MovieListAdapter : RecyclerView.Adapter<MovieListViewHolder>() {
    private val list = ArrayList<MovieItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(parent.createView(R.layout.item_movie))
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(items: List<MovieItemModel>) {
        if (items.isEmpty()) {
            return
        }

        list.addAll(items)
        notifyDataSetChanged()
    }
}