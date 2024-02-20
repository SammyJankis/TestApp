package com.adidas.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun NotificationCardComposable(modifier: Modifier, notification: NotificationUiEntity, onButtonNotificationClicked: () -> Unit) {
    MaterialTheme {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = modifier
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
            Button(
                modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp),
                onClick = { onButtonNotificationClicked() },
            ) {
                Text(
                    text = "Click to show a dialog",
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
@Preview(apiLevel = 33)
private fun NotificationCardComposablePreview() {
    NotificationCardComposable(Modifier, NotificationUiEntity.mock()) {}
}
