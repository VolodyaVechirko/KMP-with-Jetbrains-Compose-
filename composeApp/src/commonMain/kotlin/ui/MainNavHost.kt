package ui

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.query
import moe.tlaster.precompose.navigation.rememberNavigator
import ui.more.BottomSheetPage
import ui.more.CollapsingEffectScreen
import ui.more.CollapsingToolbarScreen
import ui.other.StubPage
import ui.other.WebViewPage

object Route {
    const val MAIN = "main"
    const val WEB_VIEW = "web_view"

    const val SAMPLE_1 = "sample_1"
    const val SAMPLE_2 = "sample_2"
    const val SAMPLE_3 = "sample_3"
    const val SAMPLE_4 = "sample_4"
}

@Composable
fun MainNavHost() {
    val navigator = rememberNavigator()

    NavHost(
        navigator = navigator,
        initialRoute = Route.MAIN,
    ) {
        scene(route = Route.MAIN) {
            MainPage(rootNavigator = navigator)
        }

        scene(route = Route.WEB_VIEW) {
            WebViewPage(
                url = it.query<String>("url")!!,
            )
        }

        // More menu samples
        scene(route = Route.SAMPLE_1) {
            BottomSheetPage()
        }

        scene(route = Route.SAMPLE_2) {
            CollapsingEffectScreen()
        }

        scene(route = Route.SAMPLE_3) {
            CollapsingToolbarScreen()
        }

        scene(route = Route.SAMPLE_4) {
            StubPage("Stub page")
        }
    }
}