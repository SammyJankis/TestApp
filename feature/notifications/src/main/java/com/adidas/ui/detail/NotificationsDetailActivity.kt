package com.adidas.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.adidas.entities.NotificationUiEntity
import com.adidas.entities.bundleName
import com.adidas.getParcelableObject
import com.adidas.notifications.databinding.NotificationDetailActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsDetailActivity : AppCompatActivity() {

    private lateinit var binding: NotificationDetailActivityBinding
    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = NotificationDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(binding.notificationDetailNavHostFragment.id) as NavHostFragment
        navController = navHostFragment.navController
        navController?.setGraph(
            com.adidas.notifications.R.navigation.notifications_detail_graph,
            startDestinationArgs = bundleOf(bundleName to intent.extras?.getParcelableObject(bundleName, NotificationUiEntity::class.java))
        )
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navController?.handleDeepLink(intent)
    }
}
