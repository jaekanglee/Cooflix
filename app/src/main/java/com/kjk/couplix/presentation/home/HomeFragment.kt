package com.kjk.couplix.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kjk.core.interactor.GetGenres
import com.kjk.core.interactor.GetMovies
import com.kjk.couplix.R
import com.kjk.couplix.databinding.FragmentHomeBinding
import com.kjk.couplix.framework.remote.Interactors

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    /** 이부분 해결해야 한다.
    private val viewModel by lazy {
        ViewModelProvider(this, HomeViewModelFactory().get(HomeViewModel::class.java)
    }
    */

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

    }
}