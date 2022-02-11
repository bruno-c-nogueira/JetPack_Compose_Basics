package com.example.jetpackcomposebeginners.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxCustom() {
    var isSelected by remember{ mutableStateOf(false)}

    Checkbox( checked = isSelected, onCheckedChange = {
        isSelected = it
    }, modifier = Modifier.padding(15.dp))
}