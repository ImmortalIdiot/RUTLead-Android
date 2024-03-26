package com.immortalidiot.rutlead.navigation.navBars

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.rutlead.ui.theme.ClassicGray
import com.immortalidiot.rutlead.ui.theme.LightBlue

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val navigationBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navigationBackStackEntry?.destination?.route

    NavigationBar(
        modifier = modifier.background(
            color = MaterialTheme.colorScheme.surfaceColorAtElevation(
                LocalAbsoluteTonalElevation.current)
        )
    ) {
        navigationBarItems.forEach { item: NavigationBarItem ->
            val isSelected = currentRoute == item.route
            NavigationBarItem(
                selected = (currentRoute == item.route),
                onClick = {
                    if (currentRoute != item.route) { navController.navigate(item.route) }
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.icon),
                        contentDescription = null,
                        tint = if (isSelected) LightBlue else ClassicGray
                    )
                },
                label = { Text(text = item.name) },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                        LocalAbsoluteTonalElevation.current)
                )
            )
        }
    }
}

@Preview
@Composable
fun MainNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}
