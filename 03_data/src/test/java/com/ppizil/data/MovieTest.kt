package com.ppizil.data

import android.util.Log
import com.ppizil.domain.repository.MovieRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@HiltAndroidTest
@Config(application = HiltTestApplication::class)
class MovieTest {
    @get:Rule val hiltRule = HiltAndroidRule(this)

    @Inject lateinit var repository : MovieRepository

    @Before
    fun setup(){
        hiltRule.inject()

    }

//    @Test
//    fun `01_`() = runBlocking{
//        val input = HashMap<String,String>().apply {
//            put("api_key","f5b4e00d8784190656779486ad641fc0")
//        }
//        val result = repository.fetchMovieList(input).getOrThrow()
//        Assertions.assertEquals(result,true)
//    }
}