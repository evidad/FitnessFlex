package com.example.fitnessflex

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EntryScreen() {
    var workoutType by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Workout Type:")
        OutlinedTextField(value = workoutType, onValueChange = { workoutType = it }, label = { Text("e.g., Running") })

        Spacer(modifier = Modifier.height(8.dp))
        Text("Duration (minutes):")
        OutlinedTextField(value = duration, onValueChange = { duration = it }, label = { Text("30") })

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Save logic here */ }) {
            Text("Submit")
        }
    }
}


