package com.example.softwareengineering

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwareengineering.ui.theme.CustomFontFamily

@Composable
fun QuestPageDaily(
    onButtonClicked: (Float, Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Daily Quests",
            fontFamily = CustomFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 29.sp,
            color = Color.White,
            modifier = Modifier,
            style = TextStyle(
                shadow = Shadow(
                    Color(0xFF000000).copy(0.25f),
                    offset = Offset(4f, 15f),
                    blurRadius = 4f
                )
            )
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))

        // Daily Quest Box Background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(5.dp),
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                )
                .clip(RoundedCornerShape(5.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.daily_quest_card_background),
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            // Daily Quest Box Content
            Column {
                // Quest 1
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            color = Color.Transparent
                        )
                        .drawBehind { drawBottomStroke() }
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Quest 1
                        Column(
                            modifier = Modifier.padding(
                                top = 12.dp,
                                bottom = 12.dp,
                                start = 25.dp,
                                end = 20.dp
                            )
                        ) {
                            Text(
                                text = "Open your curtains!",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color(0xFF5C7B86),
                                modifier = Modifier
                            )

                            Spacer(modifier = Modifier.padding(top = 12.dp))

                            Button(
                                onClick = {
                                    onButtonClicked(0.05f, 0)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    Color.White
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.size(53.dp, 22.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 1.dp)
                            ) {
                                Text(
                                    text = "GO !",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFF5C7B86)
                                )
                            }
                        }

                        // Point Value Quest 1
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Column(
                                modifier = Modifier,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.questpoint),
                                    contentDescription = "Point",
                                    modifier = Modifier.size(25.dp, 28.dp),
                                    contentScale = ContentScale.FillBounds
                                )

                                Text(
                                    text = "5",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF5C7B86),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }

                // Quest 2
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            color = Color.Transparent
                        )
                        .drawBehind { drawBottomStroke() }
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Quest 1
                        Column(
                            modifier = Modifier.padding(
                                top = 12.dp,
                                bottom = 12.dp,
                                start = 25.dp,
                                end = 20.dp
                            )
                        ) {
                            Text(
                                text = "Water your plants!",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color(0xFF5C7B86),
                                modifier = Modifier
                            )

                            Spacer(modifier = Modifier.padding(top = 12.dp))

                            Button(
                                onClick = {
                                    onButtonClicked(0.05f, 0)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    Color.White
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.size(53.dp, 22.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 1.dp)
                            ) {
                                Text(
                                    text = "GO !",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFF5C7B86)
                                )
                            }
                        }

                        // Point Value Quest 2
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Column(
                                modifier = Modifier,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.questpoint),
                                    contentDescription = "Point",
                                    modifier = Modifier.size(25.dp, 28.dp),
                                    contentScale = ContentScale.FillBounds
                                )

                                Text(
                                    text = "5",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF5C7B86),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }

                // Quest 3
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp))
                        .background(
                            color = Color.Transparent
                        )
                        .drawBehind { drawBottomStroke() }
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                top = 12.dp,
                                bottom = 12.dp,
                                start = 25.dp,
                                end = 20.dp
                            )
                        ) {
                            Text(
                                text = "Turn off your lights!",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color(0xFF5C7B86),
                                modifier = Modifier
                            )

                            Spacer(modifier = Modifier.padding(top = 12.dp))

                            Button(
                                onClick = {
                                    onButtonClicked(0.05f, 0)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    Color.White
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.size(53.dp, 22.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 1.dp)
                            ) {
                                Text(
                                    text = "GO !",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFF5C7B86)
                                )
                            }
                        }

                        // Point Value Quest 3
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Column(
                                modifier = Modifier,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.questpoint),
                                    contentDescription = "Point",
                                    modifier = Modifier.size(25.dp, 28.dp),
                                    contentScale = ContentScale.FillBounds
                                )

                                Text(
                                    text = "5",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF5C7B86),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuestPageWeekly(
    onButtonClicked: (Float, Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Weekly Quests",
            fontFamily = CustomFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 29.sp,
            color = Color.White,
            modifier = Modifier,
            style = TextStyle(
                shadow = Shadow(
                    Color(0xFF000000).copy(0.25f),
                    offset = Offset(4f, 15f),
                    blurRadius = 4f
                )
            )
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))

        // Weekly Quest Box Background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(5.dp),
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                )
                .clip(RoundedCornerShape(5.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.daily_quest_card_background),
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            // Weekly Quest Box Content
            Column {
                // Quest 1
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            color = Color.Transparent
                        )
                        .drawBehind { drawBottomStroke() }
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Quest 1
                        Column(
                            modifier = Modifier.padding(
                                top = 12.dp,
                                bottom = 12.dp,
                                start = 25.dp,
                                end = 20.dp
                            )
                        ) {
                            Text(
                                text = "Lorem ipsum",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color(0xFF5C7B86),
                                modifier = Modifier
                            )

                            Spacer(modifier = Modifier.padding(top = 12.dp))

                            Button(
                                onClick = {
                                    onButtonClicked(0.25f, 1)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    Color.White
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.size(53.dp, 22.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 1.dp)
                            ) {
                                Text(
                                    text = "GO !",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFF5C7B86)
                                )
                            }
                        }

                        // Point Value
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Point
                                Column(
                                    modifier = Modifier,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.questpoint),
                                        contentDescription = "Point",
                                        modifier = Modifier.size(25.dp, 28.dp),
                                        contentScale = ContentScale.FillBounds
                                    )

                                    Text(
                                        text = "25",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = Color(0xFF5C7B86),
                                        textAlign = TextAlign.Center
                                    )
                                }

                                Spacer(modifier = Modifier.padding(end = 12.dp))

                                // Coin
                                Column(
                                    modifier = Modifier,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.coin2),
                                        contentDescription = "Point",
                                        modifier = Modifier.size(25.dp, 25.dp),
                                        contentScale = ContentScale.FillBounds
                                    )

                                    Spacer(modifier = Modifier.padding(top = 4.dp))

                                    Text(
                                        text = "1",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = Color(0xFF5C7B86),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }

                // Quest 2
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            color = Color.Transparent
                        )
                        .drawBehind { drawBottomStroke() }
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Quest 1
                        Column(
                            modifier = Modifier.padding(
                                top = 12.dp,
                                bottom = 12.dp,
                                start = 25.dp,
                                end = 20.dp
                            )
                        ) {
                            Text(
                                text = "Lorem ipsum",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color(0xFF5C7B86),
                                modifier = Modifier
                            )

                            Spacer(modifier = Modifier.padding(top = 12.dp))

                            Button(
                                onClick = {
                                    onButtonClicked(0.25f, 1)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    Color.White
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.size(53.dp, 22.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 1.dp)
                            ) {
                                Text(
                                    text = "GO !",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFF5C7B86)
                                )
                            }
                        }

                        // Point Value
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Point
                                Column(
                                    modifier = Modifier,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.questpoint),
                                        contentDescription = "Point",
                                        modifier = Modifier.size(25.dp, 28.dp),
                                        contentScale = ContentScale.FillBounds
                                    )

                                    Text(
                                        text = "25",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = Color(0xFF5C7B86),
                                        textAlign = TextAlign.Center
                                    )
                                }

                                Spacer(modifier = Modifier.padding(end = 12.dp))

                                // Coin
                                Column(
                                    modifier = Modifier,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.coin2),
                                        contentDescription = "Point",
                                        modifier = Modifier.size(25.dp, 25.dp),
                                        contentScale = ContentScale.FillBounds
                                    )

                                    Spacer(modifier = Modifier.padding(top = 4.dp))

                                    Text(
                                        text = "1",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = Color(0xFF5C7B86),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }

                // Quest 3
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp))
                        .background(
                            color = Color.Transparent
                        )
                        .drawBehind { drawBottomStroke() }
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Quest 1
                        Column(
                            modifier = Modifier.padding(
                                top = 12.dp,
                                bottom = 12.dp,
                                start = 25.dp,
                                end = 20.dp
                            )
                        ) {
                            Text(
                                text = "Lorem ipsum",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color(0xFF5C7B86),
                                modifier = Modifier
                            )

                            Spacer(modifier = Modifier.padding(top = 12.dp))

                            Button(
                                onClick = {
                                    onButtonClicked(0.25f, 1)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    Color.White
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.size(53.dp, 22.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 1.dp)
                            ) {
                                Text(
                                    text = "GO !",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFF5C7B86)
                                )
                            }
                        }

                        // Point Value
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Point
                                Column(
                                    modifier = Modifier,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.questpoint),
                                        contentDescription = "Point",
                                        modifier = Modifier.size(25.dp, 28.dp),
                                        contentScale = ContentScale.FillBounds
                                    )

                                    Text(
                                        text = "25",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = Color(0xFF5C7B86),
                                        textAlign = TextAlign.Center
                                    )
                                }

                                Spacer(modifier = Modifier.padding(end = 12.dp))

                                // Coin
                                Column(
                                    modifier = Modifier,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.coin2),
                                        contentDescription = "Point",
                                        modifier = Modifier.size(25.dp, 25.dp),
                                        contentScale = ContentScale.FillBounds
                                    )

                                    Spacer(modifier = Modifier.padding(top = 4.dp))

                                    Text(
                                        text = "1",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = Color(0xFF5C7B86),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuestPageMonthly(
    onButtonClicked: (Float, Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Monthly Quest",
            fontFamily = CustomFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 29.sp,
            color = Color.White,
            modifier = Modifier,
            style = TextStyle(
                shadow = Shadow(
                    Color(0xFF000000).copy(0.25f),
                    offset = Offset(4f, 15f),
                    blurRadius = 4f
                )
            )
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))

        // Monthly Quest Box Background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(5.dp),
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                )
                .clip(RoundedCornerShape(5.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.monthlybackground),
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            // Monthly Quest Box Content
            Column {
                // Monthly Quest
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            color = Color.Transparent
                        )
                        .drawBehind { drawBottomStroke() }
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                top = 12.dp,
                                bottom = 12.dp,
                                start = 25.dp,
                                end = 20.dp
                            )
                        ) {
                            Text(
                                text = "Join an environmental event!",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color(0xFF5C7B86),
                                modifier = Modifier
                            )

                            Spacer(modifier = Modifier.padding(top = 12.dp))

                            Button(
                                onClick = {
                                    onButtonClicked(1f, 5)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    Color.White
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.size(53.dp, 22.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 1.dp)
                            ) {
                                Text(
                                    text = "GO !",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFF5C7B86)
                                )
                            }
                        }

                        // Point Value
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Point
                                Column(
                                    modifier = Modifier,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.questpoint),
                                        contentDescription = "Point",
                                        modifier = Modifier.size(25.dp, 28.dp),
                                        contentScale = ContentScale.FillBounds
                                    )

                                    Text(
                                        text = "100",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = Color(0xFF5C7B86),
                                        textAlign = TextAlign.Center
                                    )
                                }

                                Spacer(modifier = Modifier.padding(end = 12.dp))

                                // Coin
                                Column(
                                    modifier = Modifier,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.coin2),
                                        contentDescription = "Point",
                                        modifier = Modifier.size(25.dp, 25.dp),
                                        contentScale = ContentScale.FillBounds
                                    )

                                    Spacer(modifier = Modifier.padding(top = 4.dp))

                                    Text(
                                        text = "5",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = Color(0xFF5C7B86),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun DrawScope.drawBottomStroke() {
    drawLine(
        color = Color(0xFF5C7B86), // Line color
        start = Offset(0f, size.height), // Titik awal garis (kiri bawah)
        end = Offset(size.width, size.height), // Titik akhir garis (kanan bawah)
        strokeWidth = 2.dp.toPx() // Line width
    )
}