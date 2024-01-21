package ui.postfull

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.ui.AutoSizeImage
import data.PhotoModel
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.BackHandler
import org.koin.core.parameter.parametersOf
import ui.views.ErrorView
import ui.views.LoadingView

typealias OnBackPressed = () -> Unit

@Composable
fun PostFullPage(postId: String, onBackPressed: OnBackPressed) {
    BackHandler(onBack = onBackPressed)
    val viewModel = koinViewModel(
        vmClass = PostFullViewModel::class,
        parameters = { parametersOf(postId) }
    )
    val state by viewModel.state

    when (val it = state) {
        is ScreenState.Loading -> LoadingView()
        is ScreenState.Error -> ErrorView(it.message)
        is ScreenState.Success -> ContentView(
            model = it.post,
            onBackPressed = onBackPressed
        )
    }
}

@Composable
private fun ContentView(
    model: PhotoModel,
    onBackPressed: OnBackPressed = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AutoSizeImage(
            url = model.url,
            contentDescription = "image",
            modifier = Modifier.fillMaxWidth()
                .aspectRatio(model.ratio),
            contentScale = ContentScale.FillBounds,
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Button(onClick = onBackPressed) {
                Text("Back")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { }) {
                Text("Show on web")
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
