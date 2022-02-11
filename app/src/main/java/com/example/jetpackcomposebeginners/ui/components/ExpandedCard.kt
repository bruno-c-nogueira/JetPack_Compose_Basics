package com.example.jetpackcomposebeginners.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandedCard(cardImageRes: Int) {
    Card(modifier = Modifier.padding(50.dp)) {
        var expanded by remember { mutableStateOf(false) }
        Column(Modifier.clickable { expanded = !expanded }) {
            Image(
                painter = painterResource(id = cardImageRes),
                contentDescription = "Card Image",
                modifier = Modifier.padding(25.dp)
            )
            AnimatedVisibility(visible = expanded) {
                Text(text = "Jetpack Compose")
            }
        }
    }
}