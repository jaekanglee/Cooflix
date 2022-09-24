package com.cooflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.cooflix.databinding.ActivityMainBinding
import com.cooflix.view.MoviesGroupAdapter

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var viewBinding: ActivityMainBinding

    private val moviesGroupAdapter = MoviesGroupAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViewModel()
        initView()
    }

    private fun initViewModel() {
        mainViewModel.moviesGroup.observe(this) {
            moviesGroupAdapter.submitList(it)
        }
    }

    private fun initView() {
        viewBinding.recyclerView.adapter = moviesGroupAdapter
    }
}