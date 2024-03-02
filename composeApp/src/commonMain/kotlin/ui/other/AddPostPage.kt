package ui.other

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import koin.ToastManager
import org.koin.compose.getKoin

@Composable
fun AddPostPage() {
    val toastManager = getKoin().get<ToastManager>()
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(Modifier.height(16.dp))
        var authorField by remember { mutableStateOf("") }
        OutlinedTextField(
            value = authorField,
            onValueChange = { authorField = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Author") },
            placeholder = { Text(text = "John Smith") },
            supportingText = { Text(text = "Your name or username") },
            singleLine = true,
        )

        Spacer(Modifier.height(16.dp))
        var tagsField by remember { mutableStateOf("") }
        OutlinedTextField(
            value = tagsField,
            onValueChange = { tagsField = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Tags") },
            placeholder = { Text(text = "music, fun, nature") },
            supportingText = { Text(text = "Tags increasing followers") },
            singleLine = true,
        )

        Spacer(Modifier.height(16.dp))
        Text(text = "Selected photos...")
        Spacer(Modifier.height(16.dp))
        Button(onClick = { toastManager.show("Open photo picker") }) {
            // TODO: launch photo picker
            Text(text = "Select photo")
        }

        Spacer(Modifier.height(16.dp))
        var descriptionField by remember { mutableStateOf("") }
        OutlinedTextField(
            value = descriptionField,
            onValueChange = { descriptionField = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Description") },
            placeholder = { Text(text = "Some long description...") },
            minLines = 4,
        )

        Spacer(Modifier.height(24.dp))
        Button(onClick = { toastManager.show("Create a post") }, Modifier.fillMaxWidth()) {
            // TODO: create a post
            Text(text = "Create post")
        }
    }
}