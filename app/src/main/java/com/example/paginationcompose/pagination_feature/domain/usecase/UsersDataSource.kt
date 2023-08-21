package com.example.paginationcompose.pagination_feature.domain.usecase

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationcompose.pagination_feature.data_source.model.User
import com.example.paginationcompose.pagination_feature.domain.repository.HomeRepository

class UsersDataSource (private val repository: HomeRepository): PagingSource<Int , User>(){

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
       return state.anchorPosition?.let { position ->
           val page = state.closestPageToPosition(position)
           page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
       }

//        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {

        return try{
           val page = params.key ?: 1
            val response = repository.getUsers(page , 7)
            LoadResult.Page(
                data = response.users,
                prevKey = null,
                nextKey = if(response.users.isNotEmpty()) response.page +1 else null
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

}