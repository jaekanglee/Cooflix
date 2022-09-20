package data.model.movie

import com.google.gson.annotations.SerializedName

data class GenreItemResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)