package ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.ui.AutoSizeImage
import data.PhotoModel
import moe.tlaster.precompose.koin.koinViewModel
import ui.views.ErrorView
import ui.views.LoadingView

@Composable
fun HomePage(onInfoClick: (id: String) -> Unit) {
    val viewModel = koinViewModel(vmClass = MainViewModel::class)
    val state by viewModel.state

    when (val it = state) {
        is ScreenState.Loading -> LoadingView()
        is ScreenState.Error -> ErrorView(it.message)
        is ScreenState.Success -> ContentView(
            photos = it.list,
            onInfoClick = onInfoClick
        )
    }
}

@Composable
private fun ContentView(
    photos: List<PhotoModel>,
    onInfoClick: (String) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        photos.forEach { model ->
            item(key = model.url) {
                AutoSizeImage(
                    url = model.url,
                    contentDescription = "image",
                    modifier = Modifier.fillMaxWidth()
                        .aspectRatio(model.ratio)
                        .clickable { onInfoClick(model.id) },
                    contentScale = ContentScale.FillBounds,
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        item(key = "footer") {
            Button(onClick = { }) {
                Text(text = "Show Info")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}