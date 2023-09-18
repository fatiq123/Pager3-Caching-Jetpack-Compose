package com.example.paging3andcaching.database

import com.example.paging3andcaching.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {
    @GET("movie/popular?api_key=722180da59ab66d43ae332fb92be98bd&language=en-US")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): MovieResponse
}