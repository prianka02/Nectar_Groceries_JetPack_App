package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prianka.nectarcompose.R
import kotlinx.coroutines.delay

@Composable
fun DebouncedSearchBar(onSearch: (String) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val debounceTimeMillis = 500L
    var lastInputTime by remember { mutableLongStateOf(System.currentTimeMillis()) }

    LaunchedEffect(searchQuery) {
        val currentTime = System.currentTimeMillis()
        lastInputTime = currentTime
        delay(debounceTimeMillis) // Wait for user to stop typing
        if (currentTime == lastInputTime) {
            onSearch(searchQuery) // Trigger search only after the user has stopped typing
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(52.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = colorResource(id = R.color.Search_Bar_color)),
        contentAlignment = Alignment.CenterStart
    ) {
        // Placeholder for the search input
        if (searchQuery.isEmpty()) {
            Text(
                text = "Search Store",
                style = TextStyle(color = colorResource(id = R.color.nectar_gray_text_color)),
                modifier = Modifier.padding(start = 40.dp)
            )
        }

        BasicTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp),
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp)
        )

        // Search icon on the left
        Image(
            painter = painterResource(id = R.drawable.search_icon),
            contentDescription = "Search Icon",
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }
}