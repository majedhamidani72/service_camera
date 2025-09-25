package com.tadrisabtedai.service

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tadrisabtedai.service.ui.screen.PermissionCameraScreen

import com.tadrisabtedai.service.ui.theme.ServiceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ServiceTheme {
                PermissionCameraScreen()


            }
        }
    }
}

