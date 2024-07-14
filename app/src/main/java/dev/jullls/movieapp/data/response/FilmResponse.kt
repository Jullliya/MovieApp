package dev.jullls.movieapp.data.response

import dev.jullls.movieapp.data.dto.FilmDTO
import kotlinx.serialization.SerialName

internal typealias FilmResponseList = List<FilmResponseDTO>

data class FilmResponseDTO(
    val dates: Any?,
    val page: Int?,
    @SerialName(RESULTS_NAME)
    val films: List<FilmDTO>
) {
    companion object {
        private const val RESULTS_NAME = "results"
    }
}