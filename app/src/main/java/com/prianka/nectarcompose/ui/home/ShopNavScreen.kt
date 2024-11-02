package com.prianka.nectarcompose.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.ui.viewmodels.SharedLocationViewModel

@Composable
fun ShopNavScreen(
    modifier: Modifier = Modifier,
    sharedLocationViewModel: SharedLocationViewModel,
    onShowBottomBar: (Boolean) -> Unit   // Callback to control bottom bar visibility
){

    val shopNavController = rememberNavController()
    val hideNavBarRoutes = listOf("DetailScreen", "GroceriesDetailScreen")

    // Observe route to control visibility of the bottom bar
    val currentBackStackEntry by shopNavController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route

    // Hide bottom bar when on any of the specified screens
    LaunchedEffect(currentDestination) {
        onShowBottomBar(currentDestination !in hideNavBarRoutes)
    }

    NavHost(
        navController = shopNavController,
        startDestination = "ShopMain"
    ) {
        composable("ShopMain") { ShopMainScreen(modifier, shopNavController, sharedLocationViewModel) }
        composable("DetailScreen") { ProductDetailsScreen(shopNavController) }
        composable("GroceriesDetailScreen") { GroceriesDetailsScreen(shopNavController) }
        // Add more nested screens here as needed
    }

}










