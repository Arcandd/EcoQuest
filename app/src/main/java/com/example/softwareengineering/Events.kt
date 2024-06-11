package com.example.softwareengineering

import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwareengineering.ui.theme.CustomFontFamily

@Composable
fun EventGreeting() {
    Column {
        Text(
            text = "Events",
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

@Composable
fun EventCard() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.wcd),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(10.dp),
            contentScale = ContentScale.FillWidth
        )
    }
}