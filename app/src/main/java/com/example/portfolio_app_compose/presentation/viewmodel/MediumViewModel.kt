package com.example.portfolio_app_compose.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portfolio_app_compose.domain.usecase.GetLatestBlogsUseCase
import com.example.portfolio_app_compose.presentation.ui.blog.MediumUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MediumViewModel @Inject constructor(
    private val getLatestBlogsUseCase: GetLatestBlogsUseCase
) : ViewModel() {

    private val _uistate = MutableStateFlow<MediumUiState>(MediumUiState.Loading)
    val uistate: MutableStateFlow<MediumUiState> = _uistate

    init {
        fetchMediumBlogs()
    }

    private fun fetchMediumBlogs() {
        viewModelScope.launch {
            try {
                val blogs = getLatestBlogsUseCase()
                Log.d("MediumViewModel", "Fetched ${blogs.size} blogs")
                _uistate.value = MediumUiState.Success(blogs)
            } catch (e: Exception) {
                _uistate.value = MediumUiState.Error("Error fetching blogs")
            }
        }
    }
}
