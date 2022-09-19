package com.ppizil.cooflix.base


import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ppizil.cooflix.R


abstract class BaseActivity<VDB : ViewDataBinding>(
    @LayoutRes
    private val layoutResId: Int
) : AppCompatActivity() {

    protected lateinit var binding: VDB
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.apply { lifecycleOwner = this@BaseActivity }

        initNavigation()
        setupBinding()
        setupObserving()

    }

    fun initNavigation() {
        supportFragmentManager.findFragmentById(R.id.navContainer)
            ?.findNavController()?.let {
                navController = it
            }
    }

    abstract fun setupBinding()

    abstract fun setupObserving()
}
