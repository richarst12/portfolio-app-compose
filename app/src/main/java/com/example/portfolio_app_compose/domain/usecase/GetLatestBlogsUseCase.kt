package com.example.portfolio_app_compose.domain.usecase

import com.example.portfolio_app_compose.domain.model.Blog
import com.example.portfolio_app_compose.domain.repository.MediumRepository
import javax.inject.Inject

class GetLatestBlogsUseCase @Inject constructor(
    private val repository: MediumRepository
) {
    suspend operator fun invoke(): List<Blog> = repository.getLatestBlogs()
}