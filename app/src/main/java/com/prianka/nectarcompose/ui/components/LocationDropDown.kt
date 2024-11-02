package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prianka.nectarcompose.R

@Composable
fun LocationDropDown(
    label: String,
    itemList: List<String>,
    selectedItem: MutableState<String>,
    modifier: Modifier = Modifier
) {
    val isExpanded = remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = label,
            fontSize = 15.sp,
            color = colorResource(id = R.color.nectar_gray_text_color),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .clickable { isExpanded.value = !isExpanded.value },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedItem.value,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dropdown_arrow),
                    contentDescription = "Dropdown Arrow"
                )
            }

            DropdownMenu(
                expanded = isExpanded.value,
                onDismissRequest = { isExpanded.value = false }
            ) {
                itemList.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedItem.value = item
                            isExpanded.value = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDividerComponent()
    }
}
