package com.example.portfolio_app_compose.utils

import java.text.SimpleDateFormat
import java.util.Locale

object DateUtils {
    fun formatPubDate(dateString: String): String {
        return try {
            val parser = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH)
            val date = parser.parse(dateString)
            val formatter = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
            formatter.format(date ?: return dateString)
        } catch (e: Exception) {
            dateString
        }
    }
}
