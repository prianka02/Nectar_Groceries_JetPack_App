package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prianka.nectarcompose.R

@Composable
fun FilterCheckboxScreen(
    selectedCategories: MutableList<String>,
    selectedBrands: MutableList<String>
) {
    // Lists of items
    val categories = listOf("Eggs", "Noodles & Pasta", "Chips & Crisps", "Fast Food")
    val brands = listOf("Individual Collection", "Cocola", "Ifad", "Kazi Farmas")


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp)
    ) {

        Text(
            "Categories",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 23.sp,
            modifier = Modifier.padding(top = 30.dp)
        )
        // Category Checkboxes
        categories.forEach { category ->
            val isChecked = category in selectedCategories
            CheckboxWithLabel(
                text = category,
                isChecked = isChecked,
                onCheckedChange = { checked ->
                    if (checked) {
                        selectedCategories.add(category)
                    } else {
                        selectedCategories.remove(category)
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Brand Section Title
        Text(
            "Brand",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 23.sp
        )

        // Brand Checkboxes
        brands.forEach { brand ->
            val isChecked = brand in selectedBrands
            CheckboxWithLabel(
                text = brand,
                isChecked = isChecked,
                onCheckedChange = { checked ->
                    if (checked) {
                        selectedBrands.add(brand)
                    } else {
                        selectedBrands.remove(brand)
                    }
                }
            )
        }
    }
}

@Composable
fun CheckboxWithLabel(
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onCheckedChange(!isChecked) } // Toggle state on click

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CustomCheckbox(
                isChecked = isChecked,
                onCheckedChange = onCheckedChange
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text,
                fontSize = 15.sp,
                color = if (isChecked) colorResource(id = R.color.nectar_primary_color) else Color.Black,
            )
        }
    }
}

@Composable
fun CustomCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isChecked) colorResource(id = R.color.nectar_primary_color) else Color.Transparent)
            .border(
                width = 1.dp,
                color = if (isChecked) colorResource(id = R.color.nectar_primary_color) else colorResource(id = R.color.un_checked_box_color),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onCheckedChange(!isChecked) },
        contentAlignment = Alignment.Center
    ) {
        if (isChecked) {
            Icon(
                painter = painterResource(id = R.drawable.check_state),
                contentDescription = "Checked",
                tint = Color.White
            )
        }
    }
}
