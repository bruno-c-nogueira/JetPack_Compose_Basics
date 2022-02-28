package com.example.jetpackcomposebeginners.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Counter() {
    val counter = remember {
        mutableStateOf(0)
    }
        Button(
            onClick = { counter.value++ },
            modifier = Modifier.padding(bottom = 15.dp)
        ) {
            Text(
                text = "I've been clicked: ${counter.value}",
                color = Color.White,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )

        }
}