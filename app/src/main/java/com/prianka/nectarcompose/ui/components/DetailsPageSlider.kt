package com.prianka.nectarcompose.ui.components

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.data.detailsPageSliderDataList
import com.prianka.nectarcompose.data.sliderDataList
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


@ExperimentalPagerApi
@Composable
fun DetailsPageSlider(){

    val pagerState  = rememberPagerState(
        pageCount = sliderDataList.size,
        initialPage =  0,
        infiniteLoop = true
    )

    LaunchedEffect(Unit){
        while (true){
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){

    HorizontalPager(state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        itemSpacing = 1.dp
    ) { page ->

            val newDataList = detailsPageSliderDataList[page]
                Image(painter = painterResource(
                    id = newDataList.imgUrl
                ),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

            }

        //Horizontal dot indicator
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter),
            activeColor = colorResource(id = R.color.nectar_primary_color),
            spacing = 7.dp,
            indicatorWidth = 6.dp
        )
    }

}




//@OptIn(ExperimentalPagerApi::class)
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun DetailsPageSliderPreview(){
//    DetailsPageSlider()
//}