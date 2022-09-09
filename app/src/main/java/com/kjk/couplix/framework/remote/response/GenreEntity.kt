package com.kjk.couplix.framework.remote.response

import com.google.gson.annotations.SerializedName

/**
 *  영화의 모든 장르를 저장하는 Entity
 */
data class GenreEntity(
    @SerializedName("id")
    val genreId: Int,
    @SerializedName("name")
    val genreType: String
)