package com.ppizil.data.datasource

import retrofit2.Response

abstract class BaseSource {
    operator fun <T> invoke(result: Response<T>): T = kotlin.run {
        if (result.isSuccessful) {
            result.body() ?: run { throw Exception("") }
        } else
            throw Exception(result.errorBody()?.string())
    }

}