package com.example.paginationcompose.pagination_feature.data_source.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class UsersResponse(

    @SerializedName("data")
    @Expose
    val users: List<User>,

    @SerializedName("total")
    @Expose
    val total: Int,

    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("limit")
    @Expose
    val limit: Int,



//    @field:Json(name = "data")
//    @Expose
//    val users: List<User>,
//
//    @field:Json(name = "total")
//    @Expose
//    val total: Int,
//
//    @field:Json(name = "page")
//    @Expose
//    val page: Int,
//
//    @field:Json(name = "limit")
//    @Expose
//    val limit: Int,




)