package com.example.jetpackcomposebeginners.nav

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object ProfileScreen : Screen("profile_user")

    fun withArgs(args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$args")
            }
        }
    }
}
