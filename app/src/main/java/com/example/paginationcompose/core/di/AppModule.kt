package com.example.paginationcompose.core.di

import com.example.paginationcompose.core.network.ApiService
import com.example.paginationcompose.core.network.RetrofitClient1
import com.example.paginationcompose.core.network.RetrofitClient2
import com.example.paginationcompose.pagination_feature.data_source.repository_impl.HomeRepositoryImpl
import com.example.paginationcompose.pagination_feature.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    @Singleton
    fun provideApiService(): ApiService {
//        return RetrofitClient2.invoke()
        return RetrofitClient1.buildService(ApiService::class.java)
    }



    @Provides
    @Singleton
    fun homeRepository(apiService: ApiService): HomeRepository {
        return HomeRepositoryImpl(apiService)
    }

}