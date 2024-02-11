package com.adidas.domain.entities

data class Notification(val id: Int, val title: String, val message: String, val date: String, val isRead: Boolean) {

    companion object {
        fun mock(index: Int) = Notification(index, "Title $index", "Message $index", "2021-01-0$index", false)
    }
}
