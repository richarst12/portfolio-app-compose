package com.example.portfolio_app_compose.data.remote

import com.example.portfolio_app_compose.data.model.RssFeed
import retrofit2.http.GET

interface MediumApiService {
    @GET("feed/@sharmaricha7724")
    suspend fun getMediumFeed(): RssFeed
}