package com.example.paginationcompose.pagination_feature.data_source.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class User(

    // when using   .addConverterFactory(GsonConverterFactory.create()) in retrofit

    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("firstName")
    @Expose
    val firstName: String,

    @SerializedName("lastName")
    @Expose
    val lastName: String,


    @SerializedName("picture")
    @Expose
    val picture: String,





    // when using .addConverterFactory(MoshiConverterFactory.create()) in retrofit

//    @field:Json(name = "id")
//    @Expose
//    val id: String,
//
//
//    @field:Json(name = "title")
//    @Expose
//    val title: String,
//
//    @field:Json(name = "firstName")
//    @Expose
//    val firstName: String,
//
//    @field:Json(name = "lastName")
//    @Expose
//    val lastName: String,
//
//    @field:Json(name = "picture")
//    @Expose
//    val picture: String,


 )
