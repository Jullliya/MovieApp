package dev.jullls.movieapp.data.response

internal typealias DetailResponseList = List<DetailResponseDTO>

data class DetailResponseDTO(
    val genres: List<Genres>,
    val id: Int,

)
data class Genres(
    val id: Int,
    val name: String
)