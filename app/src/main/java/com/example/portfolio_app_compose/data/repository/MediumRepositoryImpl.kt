package com.example.portfolio_app_compose.data.repository


import com.example.portfolio_app_compose.data.remote.MediumApiService
import com.example.portfolio_app_compose.domain.model.Blog
import com.example.portfolio_app_compose.domain.repository.MediumRepository
import javax.inject.Inject

class MediumRepositoryImpl @Inject constructor(
    private val apiService: MediumApiService
) : MediumRepository {

    override suspend fun getLatestBlogs(): List<Blog> {
        return try {
            val response = apiService.getMediumFeed()
            val items = response.channel?.items.orEmpty()

            items.map {
                Blog(
                    title = it.title.orEmpty(),
                    link = it.link.orEmpty(),
                    pubDate = it.pubDate.orEmpty()
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}

