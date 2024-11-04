package com.prianka.nectarcompose.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme
import com.prianka.nectarcompose.ui.utils.BottomNavItems
import com.prianka.nectarcompose.ui.viewmodels.SharedLocationViewModel

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NectarComposeTheme {
                val sharedLocationViewModel: SharedLocationViewModel = viewModel() // Shared instance

                BottomNavigationScreen(sharedLocationViewModel)
            }
        }
    }
}

@Composable
fun BottomNavigationScreen(
    sharedLocationViewModel: SharedLocationViewModel = viewModel()
) {
    val bottomNavItemList = listOf(
        BottomNavItems("Shop", painterResource(R.drawable.shop_icon)),
        BottomNavItems("Explore", painterResource(R.drawable.explore_icon)),
        BottomNavItems("Cart", painterResource(R.drawable.cart_icon)),
        BottomNavItems("Favourite", painterResource(R.drawable.favourite_icon)),
        BottomNavItems("Account", painterResource(R.drawable.account_icon))
    )
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    // Track visibility of bottom navigation bar
    var showBottomBar by remember { mutableStateOf(true) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                Column {
                    NavigationBar(
                        containerColor = Color.White,
                        modifier = Modifier
                            .height(120.dp)
                            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                            .shadow(elevation = 8.dp, shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)), tonalElevation = 0.dp
                    ) {
                        bottomNavItemList.forEachIndexed { index, bottomNavItems ->

                            NavigationBarItem(
                                selected = selectedIndex == index,
                                onClick = { selectedIndex = index },
                                label = {
                                    Text(
                                        text = bottomNavItems.label,
                                        style = TextStyle(
                                            color = if (selectedIndex == index)
                                                colorResource(id = R.color.nectar_primary_color) // Selected text color (green in your case)
                                            else
                                                colorResource(id = R.color.OTP_field_underscore_color) // Unselected text color
                                        )
                                    )
                                },
                                icon = {
                                    Image(
                                        painter = bottomNavItems.icon,
                                        contentDescription = bottomNavItems.label,
                                        modifier = Modifier.size(24.dp), // Set a fixed size for icons
                                        colorFilter = ColorFilter.tint(
                                            if (selectedIndex == index)
                                                colorResource(id = R.color.nectar_primary_color) // Selected icon color (green)
                                            else
                                                colorResource(id = R.color.OTP_field_underscore_color) // Unselected icon color (gray)
                                        )
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.Transparent // Remove the oval background around the selected item
                                )
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            modifier = Modifier.padding(innerPadding),
            selectedIndex,
            sharedLocationViewModel = sharedLocationViewModel,
            onShowBottomBar = { showBottomBar = it }  // Control visibility of bottom bar
        )
    }
}

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    selectedInt: Int,
    sharedLocationViewModel: SharedLocationViewModel,
    onShowBottomBar: (Boolean) -> Unit  // Callback to show/hide bottom bar
){
    when(selectedInt){
        0 -> ShopNavScreen(modifier, sharedLocationViewModel, onShowBottomBar)
        1 -> ExploreNavScreen(modifier, onShowBottomBar)
        2 -> CartNavScreen(modifier, onShowBottomBar)
        3 -> FavouriteScreen(modifier)
        4 -> AccountScreen(modifier)
    }
}


//@Preview(showBackground = true)
//@Composable
//fun BottomNavigationScreenPreview() {
//    NectarComposeTheme {
//
//        BottomNavigationScreen()
//    }
//}