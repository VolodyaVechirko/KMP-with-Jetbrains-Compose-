package ui.other

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewState

// TODO: Add back button
// TODO: Launch without AppBar and Bottom nav
@Composable
fun WebViewPage(url: String) {
    val webViewState = rememberWebViewState(url = url)
    Column(Modifier.fillMaxSize()) {
        webViewState.let {
            println("webViewState ${it.pageTitle}, ${it.loadingState}")
        }
        WebView(
            state = webViewState,
            modifier = Modifier.fillMaxSize()
        )
    }
}