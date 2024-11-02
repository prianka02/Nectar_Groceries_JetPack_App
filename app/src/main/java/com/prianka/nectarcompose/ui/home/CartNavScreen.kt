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
fun CartNavScreen(
    modifier: Modifier = Modifier,
    onShowBottomBar: (Boolean) -> Unit   // Callback to control bottom bar visibility
    ){
    val cartNavController = rememberNavController()
    val hideNavBarRoutes = listOf("PlaceOrderScreen")

    // Observe route to control visibility of the bottom bar
    val currentBackStackEntry by cartNavController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route

    // Hide bottom bar when on any of the specified screens
    LaunchedEffect(currentDestination) {
        onShowBottomBar(currentDestination !in hideNavBarRoutes)
    }

    NavHost(
        navController = cartNavController,
        startDestination = "CartMain"
    ) {
        composable("CartMain") { CartMainScreen(modifier, cartNavController) }
        composable("PlaceOrderScreen") { PlaceOrderScreen() }
        // Add more nested screens here as needed
    }
}