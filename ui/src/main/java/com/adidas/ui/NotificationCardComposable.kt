package com.adidas.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adidas.entities.NotificationUiEntity

@Composable
fun NotificationCardComposable(notification: NotificationUiEntity) {
    MaterialTheme {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier.size(width = 240.dp, height = 100.dp)
        ) {
            Text(
                text = notification.title,
                modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp),
                textAlign = TextAlign.Center,
            )
            Text(
                text = notification.message,
                modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
@Preview(apiLevel = 33)
private fun NotificationCardComposablePreview() {
    NotificationCardComposable(notification = NotificationUiEntity.mock())
}
