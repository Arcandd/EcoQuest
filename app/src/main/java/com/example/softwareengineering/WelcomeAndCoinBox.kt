package com.example.softwareengineering

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
fun Greeting() {
    Column {
        Text(
            text = "Welcome Back!",
            color = Color.White,
            fontFamily = CustomFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 10.dp),
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
fun CoinCard() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .size(392.dp, 136.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(5.dp),
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                ),
            color = Color.Transparent,
            shape = RoundedCornerShape(5.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.coin_hover),
                    contentDescription = null,
                    modifier = Modifier
                        .matchParentSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }

            Column(
                modifier = Modifier.padding(horizontal = 21.dp, vertical = 25.dp)
            ) {
                Text(
                    text = "Your points",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontFamily = CustomFontFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "48 Coins",
                    fontFamily = CustomFontFamily,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier.padding(top = 22.dp, bottom = 92.dp, end = 21.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Go to shop",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontFamily = CustomFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}