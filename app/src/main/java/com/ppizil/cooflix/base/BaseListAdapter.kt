package com.ppizil.cooflix.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<T> (
    private val binding : ViewDataBinding
): RecyclerView.ViewHolder(binding.root){

    abstract fun bind(item : T)

    abstract fun recycled()
}