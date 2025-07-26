package com.example.portfolio_app_compose.presentation.ui.blog


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.portfolio_app_compose.presentation.ui.components.BlogCard
import com.example.portfolio_app_compose.presentation.viewmodel.MediumViewModel
import com.example.portfolio_app_compose.utils.launchCustomTab

@Composable
fun BlogScreen(viewModel: MediumViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val state = viewModel.uistate.collectAsState().value

    when (state) {
        is MediumUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is MediumUiState.Success -> {
            LazyColumn(
                contentPadding = PaddingValues(bottom = 16.dp),
                verticalArrangement = Arrangement.Top
            ) {
                items(state.blogs, key = { it.link }) { blog ->
                    BlogCard(
                        title = blog.title,
                        pubDate = blog.pubDate,
                        onClick = {
                            launchCustomTab(context, blog.link)
                        }
                    )
                }
            }
        }

        is MediumUiState.Error -> {
            Text("Error: ${state.message}")
        }
    }
}
