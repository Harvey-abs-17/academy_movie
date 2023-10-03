package com.example.academy_movie.data.service

import com.example.academy_movie.data.model.SearchMovieResponse
import com.example.academy_movie.utils.API_KEY
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET()
    suspend fun searchMovie(
        @Query("apikey") apikey: String = API_KEY,
        @Query("s") s: String,
        @Query("page") page: Int
    ): Flow<SearchMovieResponse.Search>

}