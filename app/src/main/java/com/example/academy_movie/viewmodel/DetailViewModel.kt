package com.example.academy_movie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.academy_movie.data.model.DetailMovieResponse
import com.example.academy_movie.data.model.SearchMovieResponse
import com.example.academy_movie.data.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor( private val repository: DetailRepository ) :ViewModel() {

    val loading = MutableLiveData<Boolean>()
    val movieDetail = MutableLiveData<DetailMovieResponse>()
    val similarMovies = MutableLiveData<SearchMovieResponse>()

    fun getMovieDetailViewModel( i :String ){
        viewModelScope.launch {
            loading.postValue(true)
            delay(2000)
            val movieResponse = repository.getMovieDetailRepository(i)
            movieDetail.postValue(movieResponse.body())
            val similarMoviesResponse = repository.getSimilarMovies("batman")
            similarMovies.postValue(similarMoviesResponse.body())
            loading.postValue(false)
        }
    }

}