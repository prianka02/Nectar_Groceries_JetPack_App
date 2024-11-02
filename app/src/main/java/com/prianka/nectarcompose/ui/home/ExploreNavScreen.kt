package com.prianka.nectarcompose.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun ExploreNavScreen(
    modifier: Modifier = Modifier,
    onShowBottomBar: (Boolean) -> Unit   // Callback to control bottom bar visibility
){

    val exploreNavController = rememberNavController()
    val hideNavBarRoutes = listOf("ExploreDetailsScreen", "ExploreFilter")

    // Observe route to control visibility of the bottom bar
    val currentBackStackEntry by exploreNavController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route

    // Hide bottom bar on DetailScreen, show it otherwise
    LaunchedEffect(currentDestination) {
        onShowBottomBar(currentDestination !in hideNavBarRoutes)
    }

    NavHost(
        navController = exploreNavController,
        startDestination = "ExploreMain"
    ) {
        composable("ExploreMain") { ExploreScreen(modifier, exploreNavController) }
        composable("ExploreDetailsScreen" + "/{name}") { navBackStack ->

            val groceryName = navBackStack.arguments?.getString("name")

            if (groceryName != null) {
                ExploreDetailsScreen(
                    groceryName = groceryName,
                    exploreNavController = exploreNavController
                )
            }
        }
        composable("ExploreFilter") { ExploreFilterScreen(modifier, exploreNavController) }

        // Add more nested screens here as needed
    }

}