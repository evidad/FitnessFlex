package com.example.fitnessflex
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun SettingsScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Settings (Theme / Accessibility)", style = MaterialTheme.typography.headlineSmall)

        var darkMode by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier.padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Dark Mode")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(checked = darkMode, onCheckedChange = { darkMode = it })
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate("login") {
                    popUpTo("entry") { inclusive = true }
                }
            }
        ) {
            Text("Log Out")
        }
    }
}



