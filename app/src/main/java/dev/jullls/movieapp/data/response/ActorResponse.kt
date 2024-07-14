package dev.jullls.movieapp.data.response

import dev.jullls.movieapp.data.dto.ActorDTO
import kotlinx.serialization.SerialName

internal typealias ActorResponseList = List<ActorResponseDTO>

data class ActorResponseDTO(
    val page: Int?,
    @SerialName(RESULT_NAME)
    val actors: List<ActorDTO>
) {
    companion object {
        private const val RESULT_NAME = "results"
    }
}