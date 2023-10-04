package com.example.academy_movie.ui.main.fragments.home.adapter

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.academy_movie.data.model.SearchMovieResponse
import com.example.academy_movie.data.repository.HomeRepository
import javax.inject.Inject

class HomePagingSource @Inject constructor( private val repository: HomeRepository ) :PagingSource<Int, SearchMovieResponse.Search>() {
    override fun getRefreshKey(state: PagingState<Int, SearchMovieResponse.Search>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchMovieResponse.Search> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.searchMovieRepository("batman", currentPage)
            val data = response.body()?.search ?: emptyList()
            val responseData = mutableListOf<SearchMovieResponse.Search>()
            responseData.addAll(data)
            LoadResult.Page(data = responseData, prevKey = if(currentPage == 1) null else currentPage.dec(), nextKey = currentPage.plus(1))
        }catch (e :Exception){
            Log.e("error", e.message.toString())
            LoadResult.Error(e)
        }
    }
}