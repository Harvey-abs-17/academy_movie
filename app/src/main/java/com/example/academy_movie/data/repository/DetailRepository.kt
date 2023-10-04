package com.example.academy_movie.data.repository

import com.example.academy_movie.data.service.ApiService
import javax.inject.Inject

class DetailRepository @Inject constructor(private val service: ApiService) {

    suspend fun getMovieDetailRepository(i: String) = service.getMovieDetailData( i = i )

    suspend fun getSimilarMovies( search_txt :String ) = service.searchMovie(s = search_txt, page = 1)

}