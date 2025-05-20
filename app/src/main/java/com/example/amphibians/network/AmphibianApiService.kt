package com.example.amphibians.network

import com.example.amphibians.data.Amphibian
import retrofit2.http.GET

interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
} 