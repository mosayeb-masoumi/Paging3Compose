package com.example.paginationcompose.pagination_feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paginationcompose.pagination_feature.domain.usecase.UsersDataSource
import com.example.paginationcompose.pagination_feature.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val userPager = Pager(PagingConfig(pageSize = 7)) {
        UsersDataSource(repository)
    }.flow.cachedIn(viewModelScope)
}