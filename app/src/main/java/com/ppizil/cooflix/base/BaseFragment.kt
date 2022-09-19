package com.ppizil.cooflix.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VDB : ViewDataBinding, State>(
    @LayoutRes
    private val layoutResId: Int,
) : Fragment() {

    protected lateinit var binding: VDB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layoutResId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setupBinding()
        setupObserving()
        setData()
    }

    abstract fun setupBinding()

    abstract fun setupObserving()

    abstract fun setData()

    abstract fun handleEvent(state: State)

}

