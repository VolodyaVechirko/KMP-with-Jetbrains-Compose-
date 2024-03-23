package ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ErrorView(message: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Error", style = MaterialTheme.typography.titleMedium)
        Text(text = message, style = MaterialTheme.typography.bodyMedium)
    }
}

//@Composable
//@Preview
//fun ErrorView_Preview() {
//    ErrorView(message = "Some error message")
//}