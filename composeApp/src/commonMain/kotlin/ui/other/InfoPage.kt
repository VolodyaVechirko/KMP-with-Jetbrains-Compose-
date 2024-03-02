package ui.other

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Greeting
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import kotlinproject.composeapp.generated.resources.round_add_a_photo_24
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun InfoPage() {
    var greetingText by remember { mutableStateOf("Hello World!") }
    var showImage by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            greetingText = "Compose: ${Greeting().greet()}"
            showImage = !showImage
        }) {
            Text(greetingText)
        }
        Spacer(Modifier.height(16.dp))
        Row(modifier = Modifier.height(60.dp), horizontalArrangement = Arrangement.SpaceAround) {
            Icon(
                imageVector = AccountIcon,
                contentDescription = "Icon",
                modifier = Modifier.size(56.dp),
            )
            Icon(
//                painterResource(Res.drawable.round_auto_awesome_mosaic_24),
                imageVector = AutoMosaicIcon,
                contentDescription = "Icon",
                modifier = Modifier.size(56.dp),
            )
            Icon(
                imageVector = ComplexIcon,
                contentDescription = "Apple",
                modifier = Modifier.size(56.dp),
            )

            Icon(
                painterResource(Res.drawable.round_add_a_photo_24),
                contentDescription = "Icon",
                modifier = Modifier.size(56.dp),
            )
        }
        Spacer(Modifier.height(16.dp))
        AnimatedVisibility(showImage) {
            Image(
                painterResource(Res.drawable.compose_multiplatform),
                null
            )
        }
    }
}