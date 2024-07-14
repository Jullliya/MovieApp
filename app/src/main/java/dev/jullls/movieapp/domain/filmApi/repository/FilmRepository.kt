package dev.jullls.movieapp.domain.filmApi.repository

import dev.jullls.movieapp.domain.filmApi.model.ActorModel
import dev.jullls.movieapp.domain.filmApi.model.DetailModel
import dev.jullls.movieapp.domain.filmApi.model.FilmModel

interface FilmRepository {
    suspend fun getNowShowingFilms(): List<FilmModel>
    suspend fun getPopularFilms(): List<FilmModel>
    suspend fun getActors(filmID: Int): List<ActorModel>
    suspend fun getFilmDetails(filmID: Int): DetailModel
}