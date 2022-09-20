package presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["imageUrl"], requireAll = false)
fun ImageView.imageUrl(imageUrl: String?) {
    Glide.with(this)
        .load(imageUrl)
        .into(this)
}