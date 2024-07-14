package dev.jullls.movieapp.data.dto

import kotlinx.serialization.SerialName

data class FilmDTO(
    val id: Long,
    val title: String,
    @SerialName(POSTER_NAME)
    val poster: String,
    val voteAverage: String
) {
    companion object {
        private const val POSTER_NAME = "poster_path"
    }
}