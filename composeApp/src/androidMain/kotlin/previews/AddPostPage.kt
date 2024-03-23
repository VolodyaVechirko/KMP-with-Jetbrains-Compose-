package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import koin.ToastManager
import ui.other.AddPostPage

@Composable
@Preview(showSystemUi = true)
fun AddPostPage_Preview() {
    AddPostPage(toastManager = ToastManager())
}