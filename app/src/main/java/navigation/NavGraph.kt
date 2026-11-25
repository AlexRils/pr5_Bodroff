
package com.example.pr5_f_bodroff.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pr5_f_bodroff.ui.screens.ListScreen
import com.example.pr5_f_bodroff.ui.screens.DetailScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    isDark: Boolean,
    onThemeChange: () -> Unit
) {

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {

        composable("list") {
            ListScreen(
                navController = navController,
                isDark = isDark,
                onThemeChange = onThemeChange
            )
        }

        composable(
            route = "detail/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("id") ?: 0

            DetailScreen(
                specialtyId = id,
                navController = navController
            )
        }
    }
}
