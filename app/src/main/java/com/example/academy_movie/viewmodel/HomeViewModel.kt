package com.example.academy_movie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.academy_movie.data.repository.HomeRepository
import com.example.academy_movie.ui.main.fragments.home.adapter.HomePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val loading = MutableLiveData<Boolean>()

    val movieList = Pager(PagingConfig(1)) {
        HomePagingSource(repository)
    }.flow.cachedIn(viewModelScope)

    fun activeLoading() {
        viewModelScope.launch {
            loading.postValue(true)
            delay(2000)
            loading.postValue(false)
        }
    }

}