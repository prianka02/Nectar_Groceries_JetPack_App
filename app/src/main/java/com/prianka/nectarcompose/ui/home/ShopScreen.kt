package com.prianka.nectarcompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.components.DebouncedSearchBar
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme
import kotlinx.coroutines.delay

@Composable
fun ShopScreen(modifier: Modifier = Modifier){
    var searchResult by remember { mutableStateOf("") } // Holds the search result

    Column(
        modifier = modifier.fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.colored_nectar_logo), contentDescription = "nectar logo")

        //  Set top logo and location
        Row {
            Image(painter = painterResource(id = R.drawable.location_icon), contentDescription = "location logo")
            Spacer(modifier= Modifier.width(10.dp))
            Text(
                text = "Dhaka, Banasree",
                fontWeight = FontWeight.Bold

            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Called the DebouncedSearchBar Composable and provide the onSearch callback
        DebouncedSearchBar { query ->

//            searchResult = "You searched for: $query"
        }
        Spacer(modifier = Modifier.height(16.dp))

        val sampleImages = listOf(
            "https://via.placeholder.com/300x200.png?text=Slide+1",
            "https://via.placeholder.com/300x200.png?text=Slide+2",
            "https://via.placeholder.com/300x200.png?text=Slide+3"
        )
        ImageSliderWithIndicators(imageUrls = sampleImages)


        ProductList()
    }
}


@Composable
fun ImageSliderWithIndicators(imageUrls: List<String>, slideDuration: Long = 3000L) {
    var currentIndex by remember { mutableStateOf(0) }

    // Auto-slide to the next image after the slideDuration
    LaunchedEffect(currentIndex) {
        delay(slideDuration)
        currentIndex = (currentIndex + 1) % imageUrls.size
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image slider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { change, dragAmount ->
                        change.consume()
                        if (dragAmount > 0) {
                            currentIndex = if (currentIndex > 0) currentIndex - 1 else imageUrls.size - 1
                        } else {
                            currentIndex = (currentIndex + 1) % imageUrls.size
                        }
                    }
                }
        ) {
            // Use AsyncImage instead of rememberImagePainter
            AsyncImage(
                model = imageUrls[currentIndex],  // The URL of the current image
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Indicator dots
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            imageUrls.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(if (index == currentIndex) Color.Black else Color.Gray)
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}






@Composable
fun ProductCard(
    productName: String,
    productQuantity: String,
    productPrice: String,
    productImage: Painter,
    onAddClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(150.dp)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Product Image
            Image(
                painter = productImage,
                contentDescription = null,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Product Name
            Text(
                text = productName,
//                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Product Quantity/Weight
            Text(
                text = productQuantity,
//                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Product Price
            Text(
                text = productPrice,
//                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Add to Cart Button
            IconButton(
                onClick = { onAddClick() },
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.End)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add to cart",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun ProductList() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(products) { product ->
            ProductCard(
                productName = product.name,
                productQuantity = product.quantity,
                productPrice = product.price,
                productImage = painterResource(id = product.imageRes),
                onAddClick = { /* Handle Add to Cart */ }
            )
        }
    }
}

// Sample Data
val products = listOf(
    Product("Organic Bananas", "7pcs", "$4.99", R.drawable.groceryapple),
    Product("Red Apple", "1kg", "$4.99", R.drawable.grocerybanana),
    Product("Red Apple", "1kg", "$4.99", R.drawable.grocerybanana),
    Product("Red Apple", "1kg", "$4.99", R.drawable.grocerybanana)

)

data class Product(
    val name: String,
    val quantity: String,
    val price: String,
    val imageRes: Int
)



@Preview(showBackground = true)
@Composable
fun ShopScreenPreview() {
    NectarComposeTheme {
        ShopScreen()
    }
}









