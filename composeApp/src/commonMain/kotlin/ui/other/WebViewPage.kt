package ui.other

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewState

@Composable
fun WebViewPage(url: String) {
    val webViewState = rememberWebViewState(url = url)
    Column(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
    ) {
        webViewState.let {
            println("webViewState ${it.pageTitle}, ${it.loadingState}")
        }
        WebView(
            state = webViewState,
            modifier = Modifier.fillMaxSize()
        )
    }
}