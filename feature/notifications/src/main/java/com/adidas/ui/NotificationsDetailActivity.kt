package com.adidas.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import com.adidas.entities.NotificationUiEntity
import com.adidas.entities.bundleName
import com.adidas.getParcelable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val notification = intent.getParcelable(bundleName, NotificationUiEntity::class.java)
        setContentView(ComposeView(this).apply {
            setContent {
                TextComposable(text = notification?.message ?: "No message")
            }
        })
    }
}
