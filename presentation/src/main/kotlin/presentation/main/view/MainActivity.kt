package presentation.main.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hjiee.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import presentation.main.item.group.MovieGroupListAdapter
import presentation.main.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
        }
    }
    private val listAdapter = MovieGroupListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initObserver()
        viewModel.load()
    }

    private fun initView() {
        with(binding) {
            rvMovie.adapter = listAdapter
        }
    }

    private fun initObserver() {
        viewModel.movieList.observe(this) {
            listAdapter.addAll(it)
        }
    }
}