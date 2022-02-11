package com.example.jetpackcomposebeginners.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HelloScreen() {
    var name by rememberSaveable { mutableStateOf("") }
    HelloComponent(name, onNameChange = { name = it })
}

@Composable
fun HelloComponent(currentName: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        if (currentName.isNotBlank()) {
            Text(text = "Hello $currentName")
        }
        OutlinedTextField(
            value = currentName,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )

    }
}