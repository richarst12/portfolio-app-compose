package com.example.portfolio_app_compose.presentation.ui.blog

import com.example.portfolio_app_compose.domain.model.Blog

sealed class MediumUiState {
    object Loading : MediumUiState()
    data class Success(val blogs: List<Blog>) : MediumUiState()
    data class Error(val message: String) : MediumUiState()
}