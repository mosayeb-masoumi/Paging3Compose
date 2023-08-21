package com.example.paginationcompose.pagination_feature.data_source.repository_impl

import com.example.paginationcompose.core.network.ApiService
import com.example.paginationcompose.pagination_feature.data_source.model.UsersResponse
import com.example.paginationcompose.pagination_feature.domain.repository.HomeRepository
import kotlinx.coroutines.delay
import java.io.IOException

class HomeRepositoryImpl(private val apiService: ApiService) : HomeRepository {


    var error =0
    override suspend fun getUsers(page: Int, limit: Int): UsersResponse {

        error ++
        if(error ==4)
            throw IOException("some error happened")

        delay(2000)
      return apiService.getUsers(page,limit)
    }
}