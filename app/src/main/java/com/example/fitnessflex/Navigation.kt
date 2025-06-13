package com.example.fitnessflex

sealed class Screen(val route: String) {
    object Entry : Screen("entry")
    object Map : Screen("map")
    object Settings : Screen("settings")
}
