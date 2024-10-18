package com.prianka.nectarcompose.ui.components

 import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDropDown(){
    ExposedDropdownMenuBox( expanded = true, onExpandedChange = { /*TODO*/ } ) {

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun CustomDropDownPreview() {
//    NectarComposeTheme {
//        CustomDropDown()
//    }
//}