package com.vechirko.app

import ComposeApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.createDefaultAndroid
import commonConfig

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(
                LocalImageLoader provides remember { generateImageLoader() },
            ) {
                ComposeApp()
            }
        }
    }

    /**
     * Android ImageLoader cache config
     */
    private fun generateImageLoader(): ImageLoader {
        return ImageLoader {
            takeFrom(ImageLoader.createDefaultAndroid(applicationContext))
            commonConfig()
        }
    }
}