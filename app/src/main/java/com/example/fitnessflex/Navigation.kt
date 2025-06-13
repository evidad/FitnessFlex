package com.example.fitnessflex

sealed class Screen(val route: String) {
    object Entry : Screen("entry")
    object Login : Screen("login")
    object Settings : Screen("settings")
}
