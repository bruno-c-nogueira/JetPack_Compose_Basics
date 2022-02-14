package com.example.jetpackcomposebeginners.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackcomposebeginners.dto.Message
import com.example.jetpackcomposebeginners.nav.Screen
import com.example.jetpackcomposebeginners.nav.toJson


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MessagesList(
    navController: NavHostController,
    messages: List<Message>,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        itemsIndexed(messages) { index, message ->
            MessageCard(msg = message) {
                val messageJson = message.toJson()
                navController.navigate(Screen.ProfileScreen.route +"/"+ messageJson)
            }
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
            HelloScreen()
        }

    }
}
