package com.prianka.nectarcompose.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.data.Product
import com.prianka.nectarcompose.ui.components.DebouncedSearchBar
import com.prianka.nectarcompose.ui.components.ExclusiveProductCard
import com.prianka.nectarcompose.ui.components.GroceriesRandomColoredComp
import com.prianka.nectarcompose.ui.components.ViewPagerSlider
import com.prianka.nectarcompose.ui.viewmodels.SharedLocationViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShopMainScreen(modifier: Modifier = Modifier,
                   shopNavController: NavHostController,
                   sharedLocationViewModel: SharedLocationViewModel
) {
    //    Set the Location at the top from the Location Screen through viewModel
    val location by sharedLocationViewModel.selectedZone
    Log.d("ShopScreen", location)

    var searchResult by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()


    Column(
        modifier = modifier.fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(modifier = Modifier.padding(top = 20.dp),
            painter = painterResource(id = R.drawable.colored_nectar_logo),
            contentDescription = "nectar logo"
        )

        //  Set top logo and location
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.location_icon), contentDescription = "location logo")
            Spacer(modifier= Modifier.width(10.dp))
            Text(
                text = "Dhaka, $location",      // From Location Screen
                fontWeight = FontWeight.Bold

            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Called the DebouncedSearchBar Composable and provide the onSearch callback
        DebouncedSearchBar { query ->

//            searchResult = "You searched for: $query"
        }
        Spacer(modifier = Modifier.height(16.dp))

        ViewPagerSlider()     // Image Slider Composable

        Spacer(modifier = Modifier.height(35.dp))

        Row(
            modifier = Modifier.fillMaxWidth(.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(
                text = "Exclusive Offer",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "See all",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_primary_color),
                fontWeight = FontWeight.Bold,
            )
        }
        ExclusiveProductList(shopNavController)

//        Best Selling component part
        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(
                text = "Best Selling",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "See all",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_primary_color),
                fontWeight = FontWeight.Bold,
            )
        }
        ExclusiveProductList(shopNavController)

//        Groceries Product list component
        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(
                text = "Groceries",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "See all",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_primary_color),
                fontWeight = FontWeight.Bold,
            )
        }

//       Groceries Random Background Colored Row
        GroceriesRandomColoredComp(shopNavController)
        ExclusiveProductList(shopNavController)

    }
}


@Composable
fun ExclusiveProductList(shopNavController: NavHostController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp)
    ) {
        items(exclusiveProducts) { product ->
            ExclusiveProductCard(
                productName = product.name,
                productQuantity = product.quantity,
                productPrice = product.price,
                productImage = painterResource(id = product.imageRes),
                shopNavController,
                onAddClick = {

                }
            )
        }
    }
}

// Sample Data
val exclusiveProducts = listOf(
    Product("Organic Bananas", "7pcs", "$4.99", R.drawable.grocerybanana),
    Product("Red Apple", "1kg", "$7.99", R.drawable.groceryapple),
    Product("Fruits", "5kg", "$5.99", R.drawable.freshfruit),
    Product("Red Apple", "1kg", "$3.99", R.drawable.grocerybanana),
    Product("Red Apple", "1kg", "$4.99", R.drawable.groceryapple)

)
