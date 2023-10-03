package com.example.academy_movie.data.repository

import com.example.academy_movie.data.service.ApiService
import javax.inject.Inject

class HomeRepository @Inject constructor( private val service: ApiService ) {

    suspend fun searchMovieRepository( search_txt :String, page :Int ) = service.searchMovie(s = search_txt, page = page)

}