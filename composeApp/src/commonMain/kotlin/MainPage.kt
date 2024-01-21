import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import api.ApiService
import com.seiko.imageloader.ui.AutoSizeImage
import kotlinx.coroutines.launch

@Composable
fun MainPage(onInfoClick: () -> Unit = {}) {
    val coroutineScope = rememberCoroutineScope()
    val apiService = ApiService()

    var imagesList by remember { mutableStateOf<List<PhotoModel>>(emptyList()) }

    coroutineScope.launch {
        imagesList = apiService.getPhotos()
    }

    if (imagesList.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.size(size = 64.dp)
                    .align(Alignment.Center)
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            imagesList.forEach { model ->
                item(key = model.url) {
                    AutoSizeImage(
                        url = model.url,
                        contentDescription = "image",
                        modifier = Modifier.fillMaxWidth()
                            .aspectRatio(model.ratio),
                        contentScale = ContentScale.FillBounds,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            item(key = "footer") {
                Button(onClick = onInfoClick) {
                    Text(text = "Show Info")
                }
            }
        }
    }
}