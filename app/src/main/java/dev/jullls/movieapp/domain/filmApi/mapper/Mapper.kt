package dev.jullls.movieapp.domain.filmApi.mapper

interface Mapper<E, D> {
    fun fromEntity(entity: E): D
    fun toEntity(domain: D): E
}