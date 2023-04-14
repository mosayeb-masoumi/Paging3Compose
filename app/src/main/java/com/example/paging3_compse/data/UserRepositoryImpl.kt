package com.example.paging3_compse.data

import com.example.paging3_compse.data.network.UsersApi
import com.example.paging3_compse.data.network.UsersResponse
import com.example.paging3_compse.domain.repository.UserRepository
import kotlinx.coroutines.delay
import java.io.IOException

class UserRepositoryImpl(private val api: UsersApi): UserRepository {

    var error = 0

    override suspend fun getUsers(page: Int, limit: Int): UsersResponse {

        // to create error after 3 times scrolling
        error ++
        if(error == 4)
            throw IOException()


        delay(2000L) // just to test showing progressbar (delete it)

        return api.getUsers(page, limit)
    }
}