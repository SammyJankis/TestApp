package com.adidas.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextComposable(text: String) {
    MaterialTheme {
        Text(text, color = Color.White)
    }
}

@Composable
@Preview
private fun TextComposablePreview() {
    TextComposable(text = "This is a preview")
}
