package fi.developer.quickteck.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


@Composable
fun NavigationDrawer() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.fillMaxWidth(0.8f)) {
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                DrawerItems(navController, onItemClick = {
                    drawerState.close()
                })
            }
        }
    ) {
        AppNavGraph(
            navController = navController,
            openNavigationDrawer = {
                scope.launch { drawerState.open() }
            }
        )
    }
}

@Composable
fun DrawerItems(
    navController: NavHostController,
    onItemClick: suspend () -> Unit
) {
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Menus.values().forEach { drawerItem ->
        NavigationDrawerItem(
            label = { Text(text = drawerItem.title) },
            selected = currentRoute == drawerItem.route,
            onClick = {
                scope.launch {
                    // Navigate first
                    navController.navigate(drawerItem.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                    onItemClick()
                }
            }
        )
    }
}
