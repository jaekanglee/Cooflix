package com.cooplix.remote.api

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MovieServiceFactory {
    private const val BASE_URL = "https://api.themoviedb.org/3"

    fun createService(): MovieService {
        val moshi: Moshi = Moshi.Builder().build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build().create(MovieService::class.java)
    }
}