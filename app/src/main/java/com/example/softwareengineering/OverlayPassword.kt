package com.example.softwareengineering

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.softwareengineering.ui.theme.CustomFontFamily

@Composable
fun OverlayPassword(
    onDismiss: () -> Unit, onConfirm: () -> Unit
) {
    Dialog(
        onDismissRequest = {
            onDismiss()
        }, properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.size(395.dp, 348.dp),
                elevation = CardDefaults.elevatedCardElevation(5.dp),
                colors = CardDefaults.elevatedCardColors(Color(0xFFF4FFEA))
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.overlaybackground),
                        contentDescription = "background",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 28.dp, end = 28.dp, top = 24.dp)
                    ) {
                        Text(
                            text = "Current Password",
                            fontFamily = CustomFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color(0xFF5C7B86),
                            modifier = Modifier
                        )

                        Spacer(modifier = Modifier.padding(top = 6.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xFF8FB4A3))
                                .padding(start = 12.dp, end = 12.dp, top = 17.dp, bottom = 14.dp)
                        ) {
                            Text(
                                text = "Current password...",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = Color(0xFF3D616D),
                                modifier = Modifier
                            )
                        }
                        Text(
                            text = "Please refrain from using special characters",
                            fontFamily = CustomFontFamily,
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp,
                            color = Color(0xFF5C7B86),
                            modifier = Modifier
                        )

                        Spacer(modifier = Modifier.padding(top = 23.dp))

                        Text(
                            text = "New Password",
                            fontFamily = CustomFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color(0xFF5C7B86),
                            modifier = Modifier
                        )

                        Spacer(modifier = Modifier.padding(top = 6.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xFF8FB4A3))
                                .padding(start = 12.dp, end = 12.dp, top = 17.dp, bottom = 14.dp)
                        ) {
                            Text(
                                text = "New password...",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = Color(0xFF3D616D),
                                modifier = Modifier
                            )
                        }
                    }

                    // Overlay Confirmation
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(start = 8.dp, end = 8.dp, bottom = 6.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFEBFFD6))
                                .padding(start = 12.dp, end = 12.dp, top = 17.dp, bottom = 14.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Button(
                                    onClick = {
                                        onDismiss()
                                    },
                                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                                    modifier = Modifier
                                        .size(102.dp, 38.dp)
                                        .clip(RoundedCornerShape(5.dp)),
                                    shape = RectangleShape,
                                ) {
                                    Text(
                                        text = "Cancel",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 16.sp,
                                        color = Color(0xFF3D616D),
                                        modifier = Modifier,
                                        textDecoration = TextDecoration.Underline
                                    )
                                }

                                Spacer(modifier = Modifier.padding(start = 26.dp))

                                Button(
                                    onClick = {
                                        onConfirm()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        Color(0xFF3F6352)
                                    ),
                                    modifier = Modifier
                                        .size(89.dp, 46.dp)
                                        .clip(RoundedCornerShape(5.dp)),
                                    shape = RectangleShape
                                ) {
                                    Text(
                                        text = "Done",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 16.sp,
                                        color = Color.White,
                                        modifier = Modifier
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