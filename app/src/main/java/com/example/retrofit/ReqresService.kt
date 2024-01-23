package com.example.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresService {
    @GET("/api/users")
    suspend fun getFollowerList(
        @Query("page") num: Int = 2
    ): ReqresResponse
}