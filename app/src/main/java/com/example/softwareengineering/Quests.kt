package com.example.softwareengineering

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwareengineering.ui.theme.CustomFontFamily

@Composable
fun QuestGreeting() {
    Column {
        Text(
            text = "Quests",
            fontFamily = CustomFontFamily,
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(),
            style = TextStyle(
                shadow = Shadow(
                    Color(0xFF000000).copy(0.25f),
                    offset = Offset(4f, 15f),
                    blurRadius = 4f
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuestCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.questcard),
                contentDescription = "Quest Card",
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(10.dp),
                contentScale = ContentScale.FillWidth
            )

            Column (
                modifier = Modifier.matchParentSize().padding(start = 30.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "You Have",
                    fontFamily = CustomFontFamily,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1E435E)
                )
                Text(
                    text = "Unfinished",
                    fontFamily = CustomFontFamily,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1E435E)
                )
                Text(
                    text = "Quests!",
                    fontFamily = CustomFontFamily,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1E435E)
                )
                Text(
                    text = "Go to quest page",
                    fontFamily = CustomFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color(0xFF1E435E),
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}