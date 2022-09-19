package com.ppizil.cooflix.utils

import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ppizil.cooflix.R
import com.ppizil.presentaion.utils.ToolbarListener
import com.ppizil.presentaion.utils.ToolbarType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@BindingAdapter("setToolbarView")
fun setToolbarView(viewGroup: ViewGroup, event: ToolbarListener?) {
    event?.toolbarType ?: return
    val leftBtn = viewGroup.findViewById<AppCompatButton>(R.id.btn_left)
    val titleView = viewGroup.findViewById<AppCompatTextView>(R.id.tv_page_title)

    val stringId: String? = null
    val leftIcon: Int? = null

    when (event.toolbarType) {
        ToolbarType.Normal -> "Cooflix"
    }

    stringId.let {
        titleView.text =(it)
    }

    leftIcon?.let {
        leftBtn.background = ContextCompat.getDrawable(viewGroup.context, it)
    }
}


