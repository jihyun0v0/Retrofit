package com.example.retrofit

import retrofit2.http.GET

interface HealthCheckService {
    @GET("/health")
    suspend fun checkHealth(): HealthCheckRespose
}