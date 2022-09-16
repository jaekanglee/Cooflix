package presentation.main.item.group

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hjiee.presentation.R
import presentation.ext.createView

class MovieGroupListAdapter : RecyclerView.Adapter<MovieGroupListViewHolder>() {
    private val list = ArrayList<MovieGroupListModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGroupListViewHolder {
        return MovieGroupListViewHolder(parent.createView(R.layout.item_group_movie))
    }

    override fun onBindViewHolder(holder: MovieGroupListViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(items: List<MovieGroupListModel>) {
        if (items.isEmpty()) {
            return
        }

        list.addAll(items)
        notifyDataSetChanged()
    }
}