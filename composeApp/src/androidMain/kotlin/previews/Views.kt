package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ui.views.ErrorView
import ui.views.LoadingView

@Composable
@Preview(showBackground = true)
fun ErrorView_Preview() {
    ErrorView(message = "Some error message")
}


@Composable
@Preview(showBackground = true)
fun LoadingView_Preview() {
    LoadingView()
}