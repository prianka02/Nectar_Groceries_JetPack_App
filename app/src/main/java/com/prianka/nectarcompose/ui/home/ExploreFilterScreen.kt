package com.prianka.nectarcompose.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.components.FilterCheckboxScreen
import com.prianka.nectarcompose.ui.components.NectarDesignerButton
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
fun ExploreFilterScreen(modifier: Modifier, exploreNavController: NavHostController) {
    PersistentBottomSheetScaffold(exploreNavController)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersistentBottomSheetScaffold(exploreNavController: NavHostController) {
    // Lists to store Filtered selected items
    val selectedCategories = remember { mutableStateListOf<String>() }
    val selectedBrands = remember { mutableStateListOf<String>() }



    val scaffoldState = rememberBottomSheetScaffoldState()

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val peekHeight = screenHeight * .85f
//    val bottomSheetHeight = screenHeight * 0.8f

    Box(
        modifier = Modifier
            .fillMaxSize()
            .shadow(20.dp, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(Color.White)
    ) {
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetPeekHeight = peekHeight,
            sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            sheetContainerColor = colorResource(id = R.color.Search_Bar_color),
            sheetDragHandle = {
//                if (bottomSheetState == SheetValue.PartiallyExpanded || bottomSheetState == SheetValue.Hidden) {
//                    CollapsedHandle()
//                } else {
//                    ExpandedHandle()
//                }
            },
            sheetContent = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    FilterCheckboxScreen(
                        selectedCategories = selectedCategories,
                        selectedBrands = selectedBrands
                    )

                    // Apply Filter Button
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        NectarDesignerButton(
                            text = "Apply Filter",
                            onClick = {
                                Log.d("Filtered Items", "Categories: $selectedCategories, Brands: $selectedBrands")
                                exploreNavController.navigateUp()
                            },
                        )
                    }
                }
            },
            topBar = {
                Column(
                    modifier = Modifier.fillMaxSize(),
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
                                painter = painterResource(id = R.drawable.cross_icon),
                                contentDescription = "Back Icon"
                            )
                        }
                        Text(
                            text = "Filters",
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp,
                            modifier = Modifier
                                .padding(top = 50.dp)
                                .align(Alignment.Center)

                        )
                    }
                }
            },
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFF1F1F1)),
                contentAlignment = Alignment.Center
            ) {
                Text("Scaffold Content")
            }
        }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ExploredFilterScreenPreview() {
//    NectarComposeTheme {
//        ExploreFilterScreen(modifier = Modifier, exploreNavController = rememberNavController())
//    }
//}