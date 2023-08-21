package com.example.paginationcompose.core.network

import androidx.compose.ui.unit.Constraints
import com.example.paginationcompose.core.Constants
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Route
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object RetrofitClient2 {


    operator fun invoke(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(getRetrofitClient())
//            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private fun getRetrofitClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)

            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader("Accept", "application/json")
                    it.addHeader("app-id", "64e33312fa076709aacab6fc") // mine

                }.build())
            }.also { client ->
//                    if (BuildConfig.DEBUG) {
//                        val logging = HttpLoggingInterceptor()
//                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//                        client.addInterceptor(logging)
//                    }
            }

             // when 401 happen
            .authenticator { route, response ->
                null
            }
            .build()
    }





}

