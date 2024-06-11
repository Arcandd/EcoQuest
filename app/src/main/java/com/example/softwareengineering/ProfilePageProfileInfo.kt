package com.example.softwareengineering

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwareengineering.ui.theme.CustomFontFamily

@Preview(showBackground = false)
@Composable
fun ProfilePageProfileInfo() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile picture
        Surface(
            modifier = Modifier.size(168.dp),
            color = Color.Transparent,
            shape = CircleShape,
            border = BorderStroke(1.dp, color = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .padding(9.dp)
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

        Spacer(modifier = Modifier.padding(top = 2.dp))

        // Profile info
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Profile name
            Canvas(
                modifier = Modifier
                    .width(90.dp)
            ) {
                drawLine(
                    color = Color.White,
                    start = Offset(size.width, 0f),
                    end = Offset(0f, 0f),
                    strokeWidth = 2.dp.toPx()
                )
            }

            Spacer(modifier = Modifier.padding(start = 13.dp))

            Text(
                text = "Firefly",
                fontFamily = CustomFontFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.padding(start = 13.dp))

            Canvas(
                modifier = Modifier
                    .width(90.dp)
            ) {
                drawLine(
                    color = Color.White,
                    start = Offset(size.width, 0f),
                    end = Offset(0f, 0f),
                    strokeWidth = 2.dp.toPx()
                )
            }
        }

        // Profile level
        Text(
            text = "Level 100",
            fontFamily = CustomFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.White
        )

        // Profile rank
        Text(
            text = "Rank 1",
            fontFamily = CustomFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}