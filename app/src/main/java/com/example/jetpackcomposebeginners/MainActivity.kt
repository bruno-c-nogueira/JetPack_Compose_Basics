package com.example.jetpackcomposebeginners

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.jetpackcomposebeginners.ui.components.Message
import com.example.jetpackcomposebeginners.ui.components.MessagesList
import com.example.jetpackcomposebeginners.ui.theme.JetPackComposeBeginnersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBeginnersTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MessagesList(
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
            }
        }
    }

}

