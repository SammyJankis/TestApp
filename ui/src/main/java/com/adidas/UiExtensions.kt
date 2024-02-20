package com.adidas

import android.os.Build
import android.os.Bundle

fun <T> Bundle.getParcelableObject(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(key, clazz)
    } else {
        getParcelable(key)
    }
}

