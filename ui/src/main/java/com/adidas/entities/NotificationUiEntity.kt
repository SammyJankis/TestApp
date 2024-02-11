package com.adidas.entities

data class NotificationUiEntity(
    val title: String,
    val message: String,
) {
    companion object {
        fun mock() = NotificationUiEntity(title = "Title", message = "Message")
    }
}
