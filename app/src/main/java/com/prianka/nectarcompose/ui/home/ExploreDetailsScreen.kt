package com.prianka.nectarcompose.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.data.Grocery
import com.prianka.nectarcompose.data.Product
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
fun ExploreDetailsScreen(exploreNavController: NavHostController, groceryName: String) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {

            // Back Icon image
            IconButton(
                onClick = {
                    exploreNavController.navigateUp()
                },
                modifier = Modifier
                    .padding(top = 50.dp, start = 5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.backicon),
                    contentDescription = "Back Icon"
                )
            }

            // Filter image Icon
            IconButton(
                onClick = {
                    exploreNavController.navigate("ExploreFilter")

                },
                modifier = Modifier
                    .padding(top = 50.dp, end = 5.dp)
                    .align(Alignment.TopEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.filter_icon),
                    contentDescription = "Filter Icon"
                )
            }

            Text(
                text = groceryName,
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                modifier = Modifier
                    .padding(top = 50.dp)
                    .align(Alignment.Center)

            )

        }
        Spacer(modifier = Modifier.height(20.dp))

        ExploreDetailsCategoryComp(exploreNavController)
    }
}

@Composable
fun ExploreDetailsCategoryComp(
    exploreNavController: NavHostController
) {

// Sample Data
    val groceryExploredItems = listOf(
        Product("Diet Coke", "355ml, Price", "$1.99", R.drawable.diet_coke),
        Product("Sprite Can", "325ml, Price", "$1.50", R.drawable.sprite),
        Product("Apple & Grape Juice", "2L, Price", "$15.99", R.drawable.apple_juice),
        Product("Orange Juice", "2L, Price", "$15.99", R.drawable.orange_juice),
        Product("Coca Cola Can", "325ml, Price", "$4.99", R.drawable.coke),
        Product("Pepsi Can ", "330ml, Price", "$4.99", R.drawable.pepsi)

    )

//     Grid layout starts here
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1000.dp) // Set an appropriate height constraint
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(groceryExploredItems)
            { grocery ->

                OutlinedCard(
                    modifier = Modifier
                        .width(173.dp)
                        .height(248.dp)
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    border = BorderStroke(1.dp, color = colorResource(id = R.color.nectar_gray_color)),
                    onClick = {
//                        exploreNavController.navigate("DetailScreen")
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(15.dp)

                    ) {

                        Spacer(modifier = Modifier.height(8.dp))
                        // Product Image
                        Image(
                            painter = painterResource(id = grocery.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .height(62.dp)
                                .width(103.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(13.dp))

                        // Product Name
                        Text(
                            text = grocery.name,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.card_black_text_color)
                        )

                        // Product Quantity/Weight
                        Text(
                            text = "${grocery.quantity} Price g",
                            color = colorResource(id = R.color.card_gray_text_color),
                            fontSize = 13.sp
                        )

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Product Price
                            Text(
                                text = grocery.price,
                                fontSize = 17.sp,
                                color = colorResource(id = R.color.card_black_text_color),
                                fontWeight = FontWeight.SemiBold,
                            )
                            // Add to Cart Button
                            Box(
                                modifier = Modifier
                                    .width(45.dp)
                                    .height(45.dp)
                                    .clip(RoundedCornerShape(17.dp))
                                    .background(Color.Transparent),
                                contentAlignment = Alignment.Center,
                            ) {
                                Image(
                                    modifier = Modifier
                                        .clickable {  }
                                        .width(45.dp)
                                        .height(45.dp),
                                    painter = painterResource(id = R.drawable.add_button_logo),
                                    contentDescription = "Add to Cart Button"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SignInPreview() {
//    NectarComposeTheme {
//        ExploreDetailsScreen(exploreNavController = rememberNavController(), groceryName = "")
//    }
//}