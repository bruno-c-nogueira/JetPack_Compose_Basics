package com.example.jetpackcomposebeginners.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument
import com.example.jetpackcomposebeginners.R
import com.example.jetpackcomposebeginners.UserProfile
import com.example.jetpackcomposebeginners.dto.Message
import com.example.jetpackcomposebeginners.ui.components.MessagesList
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.gson.Gson

@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MessagesList(
                navController,
                listOf(
                    Message(
                        "Naruto Uzumaki",
                        "I'm gonna be the hokage\nI'm gonna be the hokageI'm gonna be the hokageI'm gonna be the hokageI'm gonna be the hokageI'm gonna be the hokage",
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
        composable(
            route = Screen.ProfileScreen.route + "/{item}",
            arguments = listOf(navArgument("item") {
                type = NavType.StringType
            }),
            enterTransition = { _, _ -> slideInHorizontally(initialOffsetX = { it / 2 }, animationSpec = tween(300)) },
            exitTransition = { _, _ -> slideOutHorizontally(targetOffsetX = { it / 2 }, animationSpec = tween(300)) }
        ) {
            it.arguments?.getString("item")?.let { jsonString ->
                val messageUser = jsonString.fromJson(Message::class.java)

                UserProfile(navController = navController, messageUser = messageUser)
            }
        }
    }

}

fun <A> A.toJson(): String? {
    return Gson().toJson(this)
}

fun <A> String.fromJson(type: Class<A>): A {
    return Gson().fromJson(this, type)
}
