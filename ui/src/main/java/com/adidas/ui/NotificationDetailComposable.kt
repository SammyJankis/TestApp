package com.adidas.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adidas.entities.NotificationUiEntity

@Composable
fun NotificationDetailComposable(
    modifier: Modifier,
    notificationMessage: String,
    onButtonNotificationDetailChangeClicked: (notificationMessage: String) -> Unit
) {
    MaterialTheme {
        Box(modifier = modifier) {
            TextComposable(text = notificationMessage)
            Button(
                modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp),
                onClick = { onButtonNotificationDetailChangeClicked(notificationMessage) },
            ) {
                Text(
                    text = "Click to change notification",
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
@Preview(apiLevel = 33)
private fun NotificationDetailComposablePreview() {
    NotificationDetailComposable(Modifier, NotificationUiEntity.mock().message) {}
}
