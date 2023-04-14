package com.example.paging3_compse.domain.repository

import com.example.paging3_compse.data.network.UsersResponse

interface UserRepository {

    suspend fun getUsers(page:Int , limit:Int):UsersResponse
}