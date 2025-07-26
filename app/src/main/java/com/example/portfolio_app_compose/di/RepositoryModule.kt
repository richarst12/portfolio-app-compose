package com.example.portfolio_app_compose.di

import com.example.portfolio_app_compose.data.remote.MediumApiService
import com.example.portfolio_app_compose.data.repository.MediumRepositoryImpl
import com.example.portfolio_app_compose.domain.repository.MediumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMediumRepository(api: MediumApiService): MediumRepository {
        return MediumRepositoryImpl(api)
    }
}