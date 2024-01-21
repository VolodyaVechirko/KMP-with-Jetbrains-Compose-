import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.createDefaultIOS
import platform.UIKit.UIViewController

@Suppress("FunctionName")
fun MainViewController(): UIViewController = ComposeUIViewController {
    CompositionLocalProvider(
        LocalImageLoader provides remember { generateImageLoader() },
    ) {
        ComposeApp()
    }
}

/**
 * iOS ImageLoader cache config
 */
private fun generateImageLoader(): ImageLoader {
    return ImageLoader {
        takeFrom(ImageLoader.createDefaultIOS())
        commonConfig()
    }
}