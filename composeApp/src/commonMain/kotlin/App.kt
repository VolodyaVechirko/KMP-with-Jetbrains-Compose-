import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

@Composable
fun App(modifier: Modifier = Modifier) {
    MaterialTheme {
        PreComposeApp {
            val navigator = rememberNavigator()
            NavHost(
                modifier = modifier,
                // Assign the navigator to the NavHost
                navigator = navigator,
                // Navigation transition for the scenes in this NavHost, this is optional
                navTransition = NavTransition(),
                // The start destination
                initialRoute = "/main",
            ) {
                // Define a scene to the navigation graph
                scene(
                    // Scene's route path
                    route = "/main",
                    // Navigation transition for this scene, this is optional
                    navTransition = NavTransition(),
                ) {
                    MainPage(onInfoClick = { navigator.navigate("/info") })
                }

                scene(
                    // Scene's route path
                    route = "/info",
                    // Navigation transition for this scene, this is optional
                    navTransition = NavTransition(),
                ) {
                    InfoPage()
                }
            }
        }
    }
}