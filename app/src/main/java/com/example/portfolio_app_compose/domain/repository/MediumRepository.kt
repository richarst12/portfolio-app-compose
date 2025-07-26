package com.example.portfolio_app_compose.domain.repository

import com.example.portfolio_app_compose.domain.model.Blog


interface MediumRepository {
    suspend fun getLatestBlogs(): List<Blog>
}