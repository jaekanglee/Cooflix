package com.ppizil.presentaion.movielist


sealed class MovieCategories {
    object Action : MovieCategories()
    object Romantic : MovieCategories()
}

fun Int.mapToCategory() =
    when (this) {
        53 -> MovieCategories.Action
        else -> MovieCategories.Romantic
    }


//TODO("확장성으로, 로케일이나 컨텍스트를 받아 필요에 따라 처리 string.xml에서 ")
fun MovieCategories.mapToStringType(): String? =
    when (this) {
        MovieCategories.Action -> "액션"
        MovieCategories.Romantic -> "로맨틱"
        else -> "기타"
    }