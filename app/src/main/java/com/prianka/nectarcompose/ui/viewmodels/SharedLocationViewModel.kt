package com.prianka.nectarcompose.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedLocationViewModel : ViewModel() {
    private val _selectedZone = mutableStateOf("")
    val selectedZone: State<String> = _selectedZone

    private val _selectedArea = mutableStateOf("")
    val selectedArea: State<String> = _selectedArea

    fun updateZone(zone: String) {
        _selectedZone.value = zone
    }

    fun updateArea(area: String) {
        _selectedArea.value = area
    }


}