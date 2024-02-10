package com.adidas.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TextComposable(text: String) {
    MaterialTheme {
        Text(text, color = Color.White)
    }
}
