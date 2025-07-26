package com.example.portfolio_app_compose.utils

import android.content.Context
import androidx.browser.customtabs.CustomTabsIntent
import android.net.Uri
import androidx.core.net.toUri

fun launchCustomTab(context: Context, url: String) {
    val builder = CustomTabsIntent.Builder()
    val customTabsIntent = builder.build()
    customTabsIntent.launchUrl(context, url.toUri())
}