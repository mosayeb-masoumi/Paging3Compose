package com.example.paginationcompose.pagination_feature.domain.repository

import com.example.paginationcompose.pagination_feature.data_source.model.UsersResponse

interface HomeRepository {

    suspend fun getUsers(page:Int, limit: Int) : UsersResponse
//    suspend fun getBeers(page:Int, limit: Int) : List<Beer>
}