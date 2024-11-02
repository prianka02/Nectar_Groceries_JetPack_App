package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.data.Grocery

@Composable
fun GroceriesRandomColoredComp(shopNavController: NavHostController) {
        // Sample Data
        val groceryItems = listOf(
            Grocery("Pulses", R.drawable.grocery_pulses),
            Grocery("Rice", R.drawable.grocery_rice),
            Grocery("Fruits", R.drawable.freshfruit),
            Grocery("Pulses", R.drawable.grocery_pulses),
            Grocery("Rice", R.drawable.grocery_rice)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(groceryItems) { grocery ->
                val backgroundColor = remember { generateRandomPastelColor() }
                Box(
                    modifier = Modifier
                        .width(248.dp)
                        .height(105.dp)
                        .background(backgroundColor,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .clickable {
                            shopNavController.navigate("GroceriesDetailScreen")
                        },

                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize()
                            .padding(15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            modifier = Modifier
                                .height(71.dp)
                                .width(71.dp),
                            painter = painterResource(id = grocery.imageRes),
                            contentDescription = grocery.name,
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(
                            fontSize = 19.sp,
                            text = grocery.name,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }
        }
}


// Utility function to generate a random pastel color
fun generateRandomPastelColor(): Color {
    val hue = (0..360).random().toFloat()       // Full range of hues for diversity
    val saturation = 0.5f                        // Fixed low saturation for pastel
    val lightness = 0.9f                         // High lightness for pastel tones
    return Color.hsl(hue, saturation, lightness)
}