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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import koin.ToastManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.PopUpTo
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.getKoin
import ui.home.HomePage
import ui.more.MorePage
import ui.other.AddPostPage
import ui.other.InfoPage
import ui.postfull.PostFullPage

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Home : Screen(BottomNav.HOME, "Home", Icons.Filled.Home)
    data object ADD : Screen(BottomNav.ADD, "Add", Icons.Filled.Add)
    data object Friends : Screen(BottomNav.FRIENDS, "Friends", Icons.Filled.Face)
    data object More : Screen(BottomNav.MORE, "More", Icons.Filled.Menu)
}

@Composable
fun MainPage(
    rootNavigator: Navigator
) {
    // TODO: extract Navigator to VM
    val navigator = rememberNavigator()
    val toastHost = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val toastManager = getKoin().get<ToastManager>()
    LaunchedEffect(Unit) {
        toastManager.flow
            .onEach { toastHost.showSnackbar(it.message) }
            .launchIn(scope)
    }

    val tabs = listOf(
        Screen.Home,
        Screen.ADD,
        Screen.Friends,
        Screen.More
    )

    Scaffold(
        topBar = { AppBar(title = "My Universe", showToast = toastManager::show) },
        bottomBar = { BottomNavigation(navigator, tabs) },
        snackbarHost = { SnackbarHost(toastHost) },
    ) { padding ->
        NavHost(
            modifier = Modifier.padding(padding),
            navigator = navigator,
            initialRoute = BottomNav.HOME,
        ) {
            scene(route = BottomNav.HOME) {
                HomePage(onInfoClick = { postId ->
                    val route = "${BottomNav.FULL_POST}/$postId"
                    navigator.navigate(route)
                })
            }
            scene(route = BottomNav.ADD) {
                AddPostPage(
                    toastManager = getKoin().get<ToastManager>()
                )
            }
            scene(route = BottomNav.FRIENDS) {
                InfoPage()
            }
            scene(route = BottomNav.MORE) {
                MorePage(
                    navigateToSample1 = {
                        rootNavigator.navigate(Route.SAMPLE_1)
                    },
                    navigateToSample2 = {
                        rootNavigator.navigate(Route.SAMPLE_2)
                    },
                    navigateToSample3 = {
                        rootNavigator.navigate(Route.SAMPLE_3)
                    },
                    navigateToSample4 = {
                        rootNavigator.navigate(Route.SAMPLE_4)
                    },
                )
            }

            scene(route = "${BottomNav.FULL_POST}/{postId}") {
                PostFullPage(
                    postId = it.path<String>("postId")!!,
                    onBackPressed = { navigator.popBackStack() },
                    showWebPressed = { url ->
                        val route = "${Route.WEB_VIEW}?url=$url"
                        rootNavigator.navigate(route)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(title: String, showToast: (String) -> Unit) {
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
                            popUpTo = PopUpTo(route = BottomNav.HOME, inclusive = true),
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

object BottomNav {
    const val HOME = "nav_home"
    const val ADD = "nav_add"
    const val FRIENDS = "nav_friends"
    const val MORE = "nav_more"
    const val FULL_POST = "full_post"
}