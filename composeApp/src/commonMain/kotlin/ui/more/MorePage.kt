package ui.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MorePage(
    navigateToSample1: () -> Unit,
    navigateToSample2: () -> Unit,
    navigateToSample3: () -> Unit,
    navigateToSample4: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(16.dp))
        Button(onClick = navigateToSample1) {
            Text("BottomSheetScreen")
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = navigateToSample2) {
            Text("CollapsingEffectScreen")
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = navigateToSample3) {
            Text("CollapsingToolbarScreen")
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = navigateToSample4) {
            Text("StubScreen")
        }
        Spacer(Modifier.height(16.dp))
    }
}