package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ui.more.MorePage

@Composable
@Preview(showSystemUi = true)
fun MorePagePreview() {
    MorePage(
        navigateToSample1 = {},
        navigateToSample2 = {},
        navigateToSample3 = {},
        navigateToSample4 = {},
    )
}
