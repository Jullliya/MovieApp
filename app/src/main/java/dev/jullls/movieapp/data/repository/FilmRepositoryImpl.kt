package dev.jullls.movieapp.data.repository

import dev.jullls.movieapp.data.datasource.FilmApi
import dev.jullls.movieapp.domain.filmApi.model.ActorModel
import dev.jullls.movieapp.domain.filmApi.model.DetailModel
import dev.jullls.movieapp.domain.filmApi.model.FilmModel
import dev.jullls.movieapp.domain.filmApi.repository.FilmRepository

class FilmRepositoryImpl(private val api: FilmApi): FilmRepository {
    override suspend fun getNowShowingFilms(): List<FilmModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getPopularFilms(): List<FilmModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getActors(filmID: Int): List<ActorModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getFilmDetails(filmID: Int): DetailModel {
        TODO("Not yet implemented")
    }

}