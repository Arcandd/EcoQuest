package com.example.softwareengineering

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwareengineering.ui.theme.CustomFontFamily

//@Preview(showBackground = true)
@Composable
fun ProfilePageProfileSettings(
    viewModel: MainViewModel
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(430.dp, 687.dp)
        ) {
            // Background
            Image(
                painter = painterResource(id = R.drawable.background_profile_setting),
                contentDescription = "background",
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(topStart = 75f, topEnd = 75f)),
                contentScale = ContentScale.FillWidth
            )

            // Content
            Column(
                modifier = Modifier
                    .padding(18.dp)
                    .matchParentSize()
            ) {
                // Account Information
                Text(
                    text = "Account Information",
                    fontFamily = CustomFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.padding(top = 6.dp))

                // First Box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFFE7FAD4), Color(0xFFD3F1E5)
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY)
                            )
                        )
                ) {
                    // First Box Content
                    Column(
                        modifier = Modifier.padding(
                            top = 18.dp, bottom = 30.dp, start = 20.dp, end = 20.dp
                        )
                    ) {
                        // Username Setting
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = "Username",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color(0xFF5C7B86)
                                )
                                Spacer(modifier = Modifier.padding(top = 5.dp))
                                Text(
                                    text = "Firefly",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    color = Color(0xFF5C7B86)
                                )
                            }

                            // Edit Username Button
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.End
                            ) {
                                Button(
                                    onClick = {
                                        viewModel.onEditUsernameClick()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        Color(0xFF3F6352)
                                    ),
                                    shape = RoundedCornerShape(5.dp),
                                    modifier = Modifier
                                        .padding(end = 5.dp)
                                ) {
                                    Text(
                                        text = "Edit",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.padding(2.dp))

                        Canvas(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            drawLine(
                                color = Color(0xFF5C7B86),
                                start = Offset(size.width, 0f),
                                end = Offset(0f, 0f),
                                strokeWidth = 1.dp.toPx()
                            )
                        }

                        Spacer(modifier = Modifier.padding(top = 18.dp))

                        // Password Setting
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "Password",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color(0xFF5C7B86)
                                )
                                Spacer(modifier = Modifier.padding(top = 5.dp))
                                Text(
                                    text = "************",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    color = Color(0xFF5C7B86)
                                )
                            }

                            // Edit Password Button
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.End
                            ) {
                                Button(
                                    onClick = {
                                        viewModel.onEditPasswordClick()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        Color(0xFF3F6352)
                                    ),
                                    shape = RoundedCornerShape(5.dp),
                                    modifier = Modifier
                                        .padding(end = 5.dp)
                                ) {
                                    Text(
                                        text = "Edit",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.padding(2.dp))

                        Canvas(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            drawLine(
                                color = Color(0xFF5C7B86),
                                start = Offset(size.width, 0f),
                                end = Offset(0f, 0f),
                                strokeWidth = 1.dp.toPx()
                            )
                        }

                        Spacer(modifier = Modifier.padding(top = 18.dp))

                        // Email Setting
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "Email",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color(0xFF5C7B86)
                                )
                                Spacer(modifier = Modifier.padding(top = 5.dp))
                                Text(
                                    text = "********@gmail.com",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    color = Color(0xFF5C7B86)
                                )
                            }

                            // Edit Email Button
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.End
                            ) {
                                Button(
                                    onClick = {
                                        viewModel.onEditEmailClick()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        Color(0xFF3F6352)
                                    ),
                                    shape = RoundedCornerShape(5.dp),
                                    modifier = Modifier
                                        .padding(end = 5.dp)
                                ) {
                                    Text(
                                        text = "Edit",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.padding(2.dp))

                        Canvas(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            drawLine(
                                color = Color(0xFF5C7B86),
                                start = Offset(size.width, 0f),
                                end = Offset(0f, 0f),
                                strokeWidth = 1.dp.toPx()
                            )
                        }

                        Spacer(modifier = Modifier.padding(top = 18.dp))

                        // Phone Number Setting
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "Phone Number",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color(0xFF5C7B86)
                                )
                                Spacer(modifier = Modifier.padding(top = 5.dp))
                                Text(
                                    text = "You haven't linked any phone number",
                                    fontFamily = CustomFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Color(0xFF5C7B86)
                                )
                            }

                            // Edit Phone Number Button
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.End
                            ) {
                                Button(
                                    onClick = {
                                        viewModel.onEditPhoneClick()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        Color(0xFF3F6352)
                                    ),
                                    shape = RoundedCornerShape(5.dp),
                                    modifier = Modifier
                                        .padding(end = 5.dp)
                                ) {
                                    Text(
                                        text = "Edit",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.padding(2.dp))

                        Canvas(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            drawLine(
                                color = Color(0xFF5C7B86),
                                start = Offset(size.width, 0f),
                                end = Offset(0f, 0f),
                                strokeWidth = 1.dp.toPx()
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(top = 20.dp))

                // Two Factor Authentication
                Text(
                    text = "Two Factor Authentication",
                    fontFamily = CustomFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.padding(top = 6.dp))

                // Second Box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFFE7FAD4), Color(0xFFD3F1E5)
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY)
                            )
                        )
                ) {
                    // Second Box Content
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp, horizontal = 20.dp)
                    ) {
                        ClickableText(
                            text = AnnotatedString("Enable two-factor authentication"),
                            style = TextStyle(
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color(0xFF5C7B86),
                                textDecoration = TextDecoration.Underline
                            ),
                            onClick = {
                                viewModel.on2FAClick()
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.padding(top = 20.dp))

                // Account Management
                Text(
                    text = "Account Management",
                    fontFamily = CustomFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.padding(top = 6.dp))

                // Third Box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFFE7FAD4), Color(0xFFD3F1E5)
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY)
                            )
                        )
                ) {
                    // Third Box Content
                    Column(
                        modifier = Modifier.padding(
                            top = 18.dp, bottom = 18.dp, start = 20.dp, end = 20.dp
                        )
                    ) {
                        // Log Out
                        ClickableText(
                            text = AnnotatedString("Log Out"),
                            style = TextStyle(
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color(0xFF5C7B86)
                            ),
                            onClick = {
                                viewModel.onLogOutClick()
                            }
                        )

                        Spacer(modifier = Modifier.padding(2.dp))

                        Canvas(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            drawLine(
                                color = Color(0xFF5C7B86),
                                start = Offset(size.width, 0f),
                                end = Offset(0f, 0f),
                                strokeWidth = 1.dp.toPx()
                            )
                        }

                        Spacer(modifier = Modifier.padding(top = 17.dp))

                        // Delete Account
                        ClickableText(
                            text = AnnotatedString("Delete Account"),
                            style = TextStyle(
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color(0xFFD44A4A)
                            ),
                            onClick = {
                                viewModel.onDeleteAccClick()
                            }
                        )

                        Spacer(modifier = Modifier.padding(2.dp))

                        Canvas(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            drawLine(
                                color = Color(0xFF5C7B86),
                                start = Offset(size.width, 0f),
                                end = Offset(0f, 0f),
                                strokeWidth = 1.dp.toPx()
                            )
                        }
                    }
                }
            }
        }
    }

    if (viewModel.isOverlayShown) {
        OverlayUsername(
            onDismiss = {
                viewModel.onDismissOverlay()
            },
            onConfirm = {
                // viewmodel.done
                viewModel.onDismissOverlay()
            }
        )
    } else if (viewModel.isPasswordOverlayShown) {
        OverlayPassword(
            onDismiss = {
                viewModel.onDismissOverlay()
            },
            onConfirm = {
                // viewmodel.done
                viewModel.onDismissOverlay()
            }
        )
    } else if (viewModel.isEmailOverlayShown) {
        OverlayEmail(
            onDismiss = {
                viewModel.onDismissOverlay()
            },
            onConfirm = {
                // viewmodel.done
                viewModel.onDismissOverlay()
            }
        )
    } else if (viewModel.isPhoneOverlayShown) {
        OverlayPhone(
            onDismiss = {
                viewModel.onDismissOverlay()
            },
            onConfirm = {
                // viewmodel.done
                viewModel.onDismissOverlay()
            }
        )
    } else if (viewModel.is2FAOverlayShown) {
        Overlay2FA(
            onDismiss = {
                viewModel.onDismissOverlay()
            },
            onConfirm = {
                // viewmodel.done
                viewModel.onDismissOverlay()
            }
        )
    } else if (viewModel.isLogOutOverlayShown) {
        OverlayLogOut(
            onDismiss = {
                viewModel.onDismissOverlay()
            },
            onConfirm = {
                // viewmodel.done
                viewModel.onDismissOverlay()
            }
        )
    } else if (viewModel.isDeleteAccOverlayShown) {
        OverlayDeleteAcc(
            onDismiss = {
                viewModel.onDismissOverlay()
            },
            onConfirm = {
                // viewmodel.done
                viewModel.onDismissOverlay()
            }
        )
    }
}