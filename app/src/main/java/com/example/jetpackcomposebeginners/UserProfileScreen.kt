package com.example.jetpackcomposebeginners

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.jetpackcomposebeginners.dto.Message
import com.example.jetpackcomposebeginners.ui.components.ExpandedCard

@Composable
fun UserProfile(navController: NavHostController, messageUser: Message ){
    ExpandedCard(messageUser?.resImg, messageUser?.author)

}