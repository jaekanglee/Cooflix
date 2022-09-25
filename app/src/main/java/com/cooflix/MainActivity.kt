package com.cooflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cooflix.databinding.ActivityMainBinding
import com.cooflix.view.MoviesGroupAdapter

class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainViewModel((application as CooflixApp).appContainer.getMoviesGroupUseCase)  as T
            }

        }
    }
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