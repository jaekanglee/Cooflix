package com.ppizil.data.util

import retrofit2.Response

fun <T> Response<T>.perseToObject(): T =
    if (isSuccessful) {
        body() ?: run { throw Exception("") }
    } else
        throw Exception(errorBody()?.string())
