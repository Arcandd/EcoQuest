package com.example.softwareengineering

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwareengineering.ui.theme.CustomFontFamily

@Composable
fun ProfileIcon(
    coins: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Picture
        Surface(
            modifier = Modifier.size(65.dp),
            color = Color.Transparent,
            shape = CircleShape,
            border = BorderStroke(1.dp, color = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .size(65.dp)
                    .padding(5.dp)
                    .clip(CircleShape),
            ) {
                Image(
                    painter =
                    painterResource(id = R.drawable.wife3),
                    contentDescription = "user", contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
            }
        }

        Spacer(modifier = Modifier.padding(start = 12.dp))

        // Profile Name
        Column {
            Text(
                text = "Firefly",
                fontFamily = CustomFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.White
            )

            Text(
                text = "Rank 1",
                fontFamily = CustomFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            // Coin Amount
            Surface(
                modifier = Modifier
                    .size(73.dp, 40.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFFF9B3E), Color(0xFFFFC700)
                            ), start = Offset(120f, 0f),
                            end = Offset(0f, 0f)
                        )
                    ),
                color = Color.Transparent
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 13.dp)
                ) {
                    Text(
                        text = coins.toString(),
                        fontFamily = CustomFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding()
                    )

                    Spacer(modifier = Modifier.padding(start = 4.dp))

                    Image(
                        painter = painterResource(id = R.drawable.coin),
                        contentDescription = "coin",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}