package com.example.fitnessflex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.fitnessflex.ui.theme.FitnessFlexTheme
import androidx.compose.material.icons.filled.Place



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessFlexTheme {
                val navController = rememberNavController()
                val items = listOf(Screen.Entry, Screen.Map, Screen.Settings)

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route

                            items.forEach { screen ->
                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            imageVector = when (screen) {
                                                is Screen.Entry -> Icons.Default.Edit
                                                is Screen.Map -> Icons.Default.Place
                                                is Screen.Settings -> Icons.Default.Settings
                                            },
                                            contentDescription = screen.route
                                        )
                                    },
                                    selected = currentRoute == screen.route,
                                    onClick = {
                                        if (currentRoute != screen.route) {
                                            navController.navigate(screen.route)
                                        }
                                    },
                                    label = { Text(screen.route.replaceFirstChar { it.uppercase() }) }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Entry.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Entry.route) { EntryScreen() }
                        composable(Screen.Map.route) { MapScreen() }
                        composable(Screen.Settings.route) { SettingsScreen() }
                    }
                }
            }
        }
    }
}
