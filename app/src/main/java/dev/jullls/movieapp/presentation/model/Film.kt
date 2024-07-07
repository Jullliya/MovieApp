package dev.jullls.movieapp.presentation.model

data class Film(
    val image: Int,
    val name: String,
    val rating: String,
    val genres: List<String>,
    val duration: String
)