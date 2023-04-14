package com.example.paging3_compse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paging3_compse.data.UsersDataSource
import com.example.paging3_compse.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository:UserRepository):ViewModel() {

    val usersPager = Pager(
        PagingConfig(pageSize = 10)
    ){
        UsersDataSource(repository = repository)
    }.flow.cachedIn(viewModelScope)
}