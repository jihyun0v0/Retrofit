package com.example.retrofit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HealthCheckRespose(
    @SerialName("status")
    val status: String
)