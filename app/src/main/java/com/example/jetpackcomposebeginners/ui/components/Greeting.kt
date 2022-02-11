package com.example.jetpackcomposebeginners.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Greeting(names: List<String>) {
    for (name in names) {
        Text(text = name)
    }
}