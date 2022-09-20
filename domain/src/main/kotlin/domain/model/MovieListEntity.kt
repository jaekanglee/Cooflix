package domain.model

data class MovieListEntity(
    val page: Int,
    val results: List<MovieItemEntity>,
    val totalPages: Int,
    val totalResults: Int
)