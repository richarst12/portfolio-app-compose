package com.example.portfolio_app_compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.portfolio_app_compose.presentation.navigation.PortfolioAppNavHost
import com.example.portfolio_app_compose.presentation.theme.PortfolioAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioAppComposeTheme {
                PortfolioAppNavHost()
            }
        }
    }
}