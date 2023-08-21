package com.example.paginationcompose.core.network

import com.example.paginationcompose.core.Constants
import com.google.gson.JsonArray
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object RetrofitClient1 {


    fun <T> buildService(service: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient())
            .build()
        return retrofit.create(service)
    }

    private fun okhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
//            String accessToken = SharePrefManager.getToken(context); // must be inside here
                val request = chain.request()
                    .newBuilder() //                    .addHeader("Authorization", "Bearer " + SharePrefManager.getToken(context))
//                    .addHeader("Authorization", "Bearer " + "SharePrefManager.getToken(context)")
                    .addHeader("Accept", "application/json")
                    .addHeader("app-id", "64e33312fa076709aacab6fc") // mine
                    .build()
                chain.proceed(request)
            })


            // handle 401
            .authenticator { route, response ->
//                val request = RetrofitClient().buildService(ApiService::class.java)
//                val call = request.getUserList()
                // response if retrofit
//                val tokenModelResponse: retrofit2.Response<JsonArray?> = call!!.execute()

//                if (tokenModelResponse.isSuccessful) {
//                    response.request.newBuilder()
//                        .removeHeader("Authorization")
//                        .removeHeader("Accept")
//                        .addHeader(
//                            "Authorization",
//                            "Bearer " + "SharePrefManager.getToken(context)"
//                        )
//                        .addHeader("Accept", "application/json")
//                        .build()
//
//                } else {
//                    null
//                }
                null


            }.build()


    }


}