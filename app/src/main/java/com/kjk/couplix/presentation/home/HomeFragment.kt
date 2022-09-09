package com.kjk.couplix.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kjk.couplix.R
import com.kjk.couplix.databinding.FragmentHomeBinding
import timber.log.Timber

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    /**
     * 이부분 해결해야 한다.
     * 의존성 주입 부분을 어떻게 해결 해야 하는지 고민이 필요하다.
    */
    private val viewModel by lazy {
        ViewModelProvider(this, HomeViewModelFactory)
            .get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        observe()
    }

    private fun initLayout() {

    }

    private fun observe() {
        viewModel.genre.observe(viewLifecycleOwner) {
            Timber.d("${it}")
        }

        viewModel.movies.observe(viewLifecycleOwner) {
            Timber.d("${it.size}")
        }
    }
}