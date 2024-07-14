package dev.jullls.movieapp.domain.filmApi.mapper

import dev.jullls.movieapp.data.dto.FilmDTO
import dev.jullls.movieapp.domain.filmApi.model.FilmModel

class FilmMapper: Mapper<FilmModel, FilmDTO> {

    override fun fromEntity(entity: FilmModel): FilmDTO = FilmDTO(
        entity.id,
        entity.title,
        entity.poster,
        entity.voteAverage
    )

    override fun toEntity(domain: FilmDTO): FilmModel = FilmModel(
        domain.id,
        domain.title,
        domain.poster,
        domain.voteAverage
    )
}