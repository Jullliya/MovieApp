package dev.jullls.movieapp.domain.filmApi.mapper

import dev.jullls.movieapp.data.dto.ActorDTO
import dev.jullls.movieapp.domain.filmApi.model.ActorModel

class ActorMapper: Mapper<ActorModel, ActorDTO> {
    override fun fromEntity(entity: ActorModel): ActorDTO = ActorDTO(
        entity.id,
        entity.name,
        entity.image
    )

    override fun toEntity(domain: ActorDTO): ActorModel = ActorModel(
        domain.id,
        domain.profilePath,
        domain.name
    )
}