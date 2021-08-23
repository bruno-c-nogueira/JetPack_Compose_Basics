package com.example.jetpackcomposebeginners

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebeginners.ui.theme.JetPackComposeBeginnersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBeginnersTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Conversation(
                        listOf(
                            Message(
                                "Sasuke Uchiha",
                                "Hey my pleasure is learn JetPack Compose",
                                R.drawable.sasuke
                            ),
                            Message(
                                "Naruto Uzumaki",
                                "I'm gonna be the hokage\nI'm gonna be the hokageI'm gonna be the hokageI'm gonna be the hokageI'm gonna be the hokageI'm gonna be the hokage",
                                R.drawable.naruto
                            )
                        )

                    )
                }
            }
        }
    }

    data class Message(val author: String, val body: String, val resImg: Int)

    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
                painter = painterResource(id = msg.resImg),
                contentDescription = "Profile"
            )
            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor: Color by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.secondary else MaterialTheme.colors.surface,
            )

            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )

                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium, elevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {

                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }
            }


        }
    }

    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            itemsIndexed(messages) { index, message ->
                MessageCard(msg = message)
                if (index < messages.size.minus(1))
                    Divider(
                        color = Color.Gray, thickness = 1.dp,
                        modifier = Modifier.padding(all = 8.dp)
                    )
            }

        }
    }

    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun DefaultPreview() {
        JetPackComposeBeginnersTheme {


            Conversation(
                listOf(
                    Message(
                        "Sasuke Uchiha",
                        "Hey my pleasure is learn JetPack Compose",
                        R.drawable.sasuke
                    ),
                    Message(
                        "Naruto Uzumaki",
                        "I'm gonna be the hokage",
                        R.drawable.naruto
                    ),
                )
            )


        }
    }

}

