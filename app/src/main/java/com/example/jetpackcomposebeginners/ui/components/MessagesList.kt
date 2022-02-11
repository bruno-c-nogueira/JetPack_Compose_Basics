package com.example.jetpackcomposebeginners.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebeginners.R
import com.example.jetpackcomposebeginners.ui.theme.JetPackComposeBeginnersTheme


data class Message(val author: String, val body: String, val resImg: Int)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MessagesList(messages: List<Message>) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        itemsIndexed(messages) { index, message ->
            MessageCard(msg = message)
            if (index < messages.size.minus(1)) {
                Divider(
                    color = Color.Gray, thickness = 1.dp,
                    modifier = Modifier.padding(all = 8.dp)
                )
            }

        }
        item {
            Greeting(listOf("Bruno", "Jose", "Paulo"))
        }
        item {
            Counter()
        }
        item {
            CheckBoxCustom()
        }
        item {
            ExpandedCard(R.drawable.sasuke)
        }
        item {
            HelloScreen()
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
fun DefaultPreview() {
    JetPackComposeBeginnersTheme {
        MessagesList(
            listOf(
                Message(
                    "Naruto Uzumaki",
                    "I'm gonna be the hokage",
                    R.drawable.naruto
                ),
                Message(
                    "Sasuke Uchiha",
                    "Hey my pleasure is learn JetPack Compose",
                    R.drawable.sasuke
                )
            )
        )
    }
}