package presentation.main.item.group

import presentation.main.item.movie.MovieItemModel

data class MovieGroupListModel(
    val genre: Int,
    val title: String,
    val movieList: List<MovieItemModel>,
)