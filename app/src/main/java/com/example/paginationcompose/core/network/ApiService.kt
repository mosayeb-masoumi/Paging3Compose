package com.example.paginationcompose.core.network

import com.example.paginationcompose.pagination_feature.data_source.model.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("user")
    suspend fun getUsers(@Query("page") page:Int , @Query("limit") limit: Int) : UsersResponse


//    @GET("beers")
//    suspend fun getBeers(@Query("page") page:Int , @Query("per_page") limit: Int) : List<Beer>




//    companion object {
//
//        private const val BASE_URL = "https://dummyapi.io/data/v1/"
//
//        operator fun invoke(): ApiService {
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .client(getRetrofitClient())
//                .addConverterFactory(MoshiConverterFactory.create())
//                .build()
//                .create(ApiService::class.java)
//        }
//
//        private fun getRetrofitClient(): OkHttpClient {
//            return OkHttpClient.Builder()
//                .addInterceptor { chain ->
//                    chain.proceed(chain.request().newBuilder().also {
//                        it.addHeader("Accept", "application/json")
////                        it.addHeader("app-id", "62cceaafb592b449c3aad899")  //belal
//                        it.addHeader("app-id", "64e33312fa076709aacab6fc") // mine
//
//                    }.build())
//                }.also { client ->
////                    if (BuildConfig.DEBUG) {
////                        val logging = HttpLoggingInterceptor()
////                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
////                        client.addInterceptor(logging)
////                    }
//                }.build()
//        }
//    }
}