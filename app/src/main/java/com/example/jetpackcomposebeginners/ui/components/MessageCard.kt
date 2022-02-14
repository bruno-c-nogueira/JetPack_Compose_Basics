package com.example.jetpackcomposebeginners.ui.components

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.example.jetpackcomposebeginners.R
import com.example.jetpackcomposebeginners.dto.Message
import com.example.jetpackcomposebeginners.ui.theme.JetPackComposeBeginnersTheme

@Composable
fun MessageCard(msg: Message, onProfileImgClicked: (Message) -> Unit?) {
    Row(modifier = Modifier.padding(all = 8.dp).fillMaxWidth()) {
        Image(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .clickable { onProfileImgClicked.invoke(msg) }
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
                style = MaterialTheme.typography.h1
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
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode", device = "spec:Normal;1080;1920;px;480dpi;portrait"
)
@Composable
fun test(){
    JetPackComposeBeginnersTheme {
        MessageCard(Message("jdw", "teste", R.drawable.naruto)){}
    }
}
