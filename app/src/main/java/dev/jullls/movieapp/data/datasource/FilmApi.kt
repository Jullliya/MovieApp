package dev.jullls.movieapp.data.datasource

import dev.jullls.movieapp.data.response.ActorResponseList
import dev.jullls.movieapp.data.response.FilmResponseList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmApi {

    @GET(FILM_NOW_SHOWING_ENDPOINT)
    fun getNowShowingFilms(
        @Query(API_KEY_PARAMETER) apiKey: String = API_KEY
    ): FilmResponseList

    @GET(FILM_POPULAR_ENDPOINT)
    fun getPopularFilms(
        @Query(API_KEY_PARAMETER) apiKey: String = API_KEY,
    ): FilmResponseList

    @GET(ACTOR_ENDPOINT)
    fun getActors(
        @Query(API_KEY_PARAMETER) apiKey: String = API_KEY,
        @Path(ID_PARAMETER) id: Int,
    ): ActorResponseList

    @GET(FILM_DETAILS_ENDPOINT)
    fun getFilDetails(
        @Query(API_KEY_PARAMETER) apiKey: String = API_KEY,
        @Path(ID_PARAMETER) id: Int
    )

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "08bec9bebb3da7c63079849af72e8569"
        const val FILM_NOW_SHOWING_ENDPOINT = "movie/now_showing"
        const val FILM_POPULAR_ENDPOINT = "movie/popular"
        const val ACTOR_ENDPOINT = "movie/{id}/credits"
        const val FILM_DETAILS_ENDPOINT = "movie/{id}"
        const val API_KEY_PARAMETER = "apiKey"
        const val ID_PARAMETER = "id"
    }
}