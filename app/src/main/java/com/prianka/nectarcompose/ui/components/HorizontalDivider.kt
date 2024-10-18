package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.prianka.nectarcompose.R

@Composable
fun HorizontalDividerComponent(){
            HorizontalDivider(
                color = colorResource(id = R.color.nectar_gray_color),
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
            )
}

