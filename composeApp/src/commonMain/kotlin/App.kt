import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import koin.appModule
import moe.tlaster.precompose.PreComposeApp
import org.koin.compose.KoinApplication
import ui.MainNavHost

@Composable
fun ComposeApp() {
    KoinApplication(application = {
        modules(appModule())
    }) {
        MaterialTheme {
            PreComposeApp {
                MainNavHost()
            }
        }
    }
}