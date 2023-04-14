package com.example.paging3_compse.di

import com.example.paging3_compse.data.UserRepositoryImpl
import com.example.paging3_compse.data.network.UsersApi
import com.example.paging3_compse.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUsersApi(): UsersApi = UsersApi()


    @Provides
    @Singleton
    fun provideUserRepository(api:UsersApi):UserRepository {
        return UserRepositoryImpl(api)
    }

}