package dev.jullls.movieapp.data.dto

import kotlinx.serialization.SerialName

data class ActorDTO(
    val id: Int,
    val name: String,
    @SerialName(PROFILE_NAME)
    val profilePath: String
) {
    companion object {
        private const val PROFILE_NAME = "profile_path"
    }
}