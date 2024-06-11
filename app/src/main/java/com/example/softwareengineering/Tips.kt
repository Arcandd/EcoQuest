package com.example.softwareengineering

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwareengineering.ui.theme.CustomFontFamily

@Composable
fun TipsGreeting() {
    Column {
        Text(
            text = "Daily Tips",
            fontFamily = CustomFontFamily,
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
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

@Preview
@Composable
fun TipsOne() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.tipcard),
                contentDescription = "Tips One",
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(10.dp),
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier.matchParentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.padding(start = 8.dp))

                Image(
                    painter = painterResource(id = R.drawable.water),
                    contentDescription = "water",
                    modifier = Modifier.size(32.dp)
                )

                Spacer(modifier = Modifier.padding(start = 8.dp))

                Column {
                    Text(
                        text = "Conserve Water",
                        fontFamily = CustomFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Text(
                        text = "Turn off your sink if you don't use it",
                        fontFamily = CustomFontFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun TipsTwo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.tipcard),
                contentDescription = "Tips Two",
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(10.dp),
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier.matchParentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.padding(start = 8.dp))

                Image(
                    painter = painterResource(id = R.drawable.earth),
                    contentDescription = "earth",
                    modifier = Modifier.size(32.dp)
                )

                Spacer(modifier = Modifier.padding(start = 8.dp))

                Column {
                    Text(
                        text = "Reduce, Reuse, Recycle",
                        fontFamily = CustomFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Text(
                        text = "Simple actions for sustainable future",
                        fontFamily = CustomFontFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun TipsThree() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.tipcard),
                contentDescription = "Tips Three",
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(10.dp),
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier.matchParentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.padding(start = 8.dp))

                Image(
                    painter = painterResource(id = R.drawable.plant),
                    contentDescription = "plant",
                    modifier = Modifier.size(32.dp)
                )

                Spacer(modifier = Modifier.padding(start = 8.dp))

                Column {
                    Text(
                        text = "Plant Trees",
                        fontFamily = CustomFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Text(
                        text = "Contribute to reforestation projects",
                        fontFamily = CustomFontFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}