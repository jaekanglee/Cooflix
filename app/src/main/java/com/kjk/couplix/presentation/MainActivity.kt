package com.kjk.couplix.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kjk.couplix.R
import com.kjk.couplix.databinding.ActivityMainBinding

/**
 *  MainActivity에서
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initLayout()
    }

    private fun initLayout() {

    }
}