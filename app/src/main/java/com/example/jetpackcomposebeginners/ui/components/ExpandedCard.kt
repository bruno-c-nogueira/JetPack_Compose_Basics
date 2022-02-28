package com.example.jetpackcomposebeginners.ui.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebeginners.R
import com.example.jetpackcomposebeginners.dto.Message
import com.example.jetpackcomposebeginners.ui.theme.JetPackComposeBeginnersTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandedCard(cardImageRes: Int?, downMessage: String?) {
    Card(modifier = Modifier.padding(50.dp)) {
        var expanded by remember { mutableStateOf(false) }
        Column(
            Modifier.clickable { expanded = !expanded },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            cardImageRes?.let {
                Image(
                    painter = painterResource(id = cardImageRes),
                    contentDescription = "Card Image",
                    modifier = Modifier
                        .padding(25.dp)
                        .height(250.dp)
                        .width(250.dp)
                        .clip(if(expanded) RectangleShape else CircleShape )
                        .border(1.5.dp, MaterialTheme.colors.secondary, if(expanded) RectangleShape else CircleShape)
                )
                AnimatedVisibility(visible = expanded) {
                    downMessage?.let {
                        Text(
                            text = it, style = MaterialTheme.typography.h1
                        )
                    }
                }
            }
        }

    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode", device = "spec:Normal;1080;1920;px;480dpi;portrait"
)
@Composable
fun ExpandedCardPreview(){
    JetPackComposeBeginnersTheme {
        ExpandedCard(R.drawable.sasuke, "Sasuke Uchiha")
    }
}

