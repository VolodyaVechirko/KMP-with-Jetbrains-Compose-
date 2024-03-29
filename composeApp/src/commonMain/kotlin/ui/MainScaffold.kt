package ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.PopUpTo
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import ui.home.MainPage
import ui.other.AddPostPage
import ui.other.InfoPage
import ui.other.StubPage
import ui.postfull.PostFullPage

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Home : Screen(Route.HOME, "Home", Icons.Filled.Home)
    data object ADD : Screen(Route.ADD, "Add", Icons.Filled.Add)
    data object Friends : Screen(Route.FRIENDS, "Friends", Icons.Filled.Face)
    data object More : Screen(Route.MORE, "More", Icons.Filled.Menu)
}

typealias ShowToastAction = (any: Any) -> Unit

@Composable
fun MainScaffold() {
    // TODO: extract navigator to VM; showToast to VM
    val navigator = rememberNavigator()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val showToast: ShowToastAction = {
        scope.launch {
            snackbarHostState.showSnackbar(it.toString())
        }
    }

    val tabs = listOf(
        Screen.Home,
        Screen.ADD,
        Screen.Friends,
        Screen.More
    )

    Scaffold(
        topBar = { AppBar(title = "My Universe", showToast = showToast) },
        bottomBar = { BottomNavigation(navigator, tabs) },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { padding ->
        NavBarConfig(navigator, modifier = Modifier.padding(padding))
    }
}

@Composable
private fun NavBarConfig(
    navigator: Navigator,
    modifier: Modifier
) {
    NavHost(
        modifier = modifier,
        navigator = navigator,
        initialRoute = Route.HOME,
    ) {
        scene(route = Route.HOME) {
            MainPage(onInfoClick = { postId ->
                val route = "${Route.FULL_POST}/$postId"
                navigator.navigate(route)
            })
        }
        scene(route = Route.ADD) {
            AddPostPage()
        }
        scene(route = Route.FRIENDS) {
            InfoPage()
        }
        scene(route = Route.MORE) {
//            MoreView()
            StubPage(Screen.More.title)
        }

        scene(route = "${Route.FULL_POST}/{${Route.POST_ID}}") {
            val postId = it.path<String>(Route.POST_ID)!!
            PostFullPage(postId = postId, onBackPressed = {
                navigator.popBackStack()
            })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(title: String, showToast: ShowToastAction) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = { showToast("Share clicked") }) {
                Icon(Icons.Filled.Share, null)
            }
            IconButton(onClick = { showToast("Settings clicked") }) {
                Icon(Icons.Filled.Settings, null)
            }
        }
    )
}

@Composable
private fun BottomNavigation(
    navigator: Navigator,
    items: List<Screen>
) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.secondaryContainer) {
        val currentRoute = navigator.currentRoute()
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    selectedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    indicatorColor = MaterialTheme.colorScheme.inversePrimary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                onClick = {
                    navigator.navigate(
                        screen.route,
                        NavOptions(
                            popUpTo = PopUpTo(route = Route.HOME, inclusive = true),
                            launchSingleTop = true
                        )
                    )
                }
            )
        }
    }
}

@Composable
private fun Navigator.currentRoute(): String? {
    return currentEntry.collectAsState(null)
        .value?.route?.route
}

object Route {
    const val HOME = "nav_home"
    const val ADD = "nav_add"
    const val FRIENDS = "nav_friends"
    const val MORE = "nav_more"
    const val FULL_POST = "full_post"

    const val POST_ID = "post_id"
}