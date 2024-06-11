package com.example.softwareengineering

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.softwareengineering.ui.theme.CustomFontFamily

@Composable
fun ShopPage(
    questViewModel: QuestViewModel = viewModel()
) {
    val uiState by questViewModel.uiState.collectAsState()
    ShopPagePreview(uiState.coins)
}

@Composable
private fun ShopPagePreview(
    coins: Int
) {
    // Background
    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_page),
            contentDescription = "background",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
    }

    Column(
        modifier = Modifier
            .padding(18.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 56.dp))

        ProfileIcon(coins)

        Spacer(modifier = Modifier.padding(top = 28.dp))

        Column(
            modifier = Modifier.padding(7.dp)
        ) {
            ExchangeShopHeader()

            Spacer(modifier = Modifier.padding(top = 51.dp))

            ShopPageItems()
        }
    }
}

@Preview
@Composable
private fun ShopPageItems() {
    // Shop Items
    Column(
        modifier = Modifier
    ) {
        // Outer Box
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFDED2BB))
                .border(
                    width = 5.dp,
                    color = Color.White
                )
                .padding(25.dp),
            contentAlignment = Alignment.Center
        ) {
            // Box Content
            Column {
                // Content Row 1
                Row {
                    // Content 1
                    Box(
                        modifier = Modifier
                            .size(150.dp, 179.dp)
                            .background(Color.White)
                            .padding(
                                start = 12.dp,
                                end = 12.dp,
                                top = 12.dp,
                                bottom = 7.dp
                            ),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.voucher_1),
                                contentDescription = "Voucher 1",
                                modifier = Modifier
                                    .size(126.dp, 107.dp)
                                    .clip(RoundedCornerShape(2.dp))
                            )

                            Spacer(modifier = Modifier.padding(top = 4.dp))

                            Text(
                                text = "Voucher 1",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color(0xFF626262)
                            )

                            Row(
                                modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                // Add to Cart Box
                                Box(
                                    modifier = Modifier
                                        .size(40.dp, 19.dp)
                                        .background(
                                            Color(0xFF7ACAC7),
                                            shape = RoundedCornerShape(1.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Add",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.White
                                    )
                                }

                                // Item Price
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "15",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = Color(0xFF626262)
                                    )

                                    Spacer(modifier = Modifier.padding(start = 4.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.item_price_icon),
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(start = 30.dp))

                    // Content 2
                    Box(
                        modifier = Modifier
                            .size(150.dp, 179.dp)
                            .background(Color.White)
                            .padding(
                                start = 12.dp,
                                end = 12.dp,
                                top = 12.dp,
                                bottom = 7.dp
                            ),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.voucher_2),
                                contentDescription = "Voucher 1",
                                modifier = Modifier
                                    .size(126.dp, 107.dp)
                                    .clip(RoundedCornerShape(2.dp))
                            )

                            Spacer(modifier = Modifier.padding(top = 4.dp))

                            Text(
                                text = "Voucher 2",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color(0xFF626262)
                            )

                            Row(
                                modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                // Add to Cart Box
                                Box(
                                    modifier = Modifier
                                        .size(40.dp, 19.dp)
                                        .background(
                                            Color(0xFF7ACAC7),
                                            shape = RoundedCornerShape(1.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Add",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.White
                                    )
                                }

                                // Item Price
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "15",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = Color(0xFF626262)
                                    )

                                    Spacer(modifier = Modifier.padding(start = 4.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.item_price_icon),
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(top = 20.dp))

                // Content Row 2
                Row {
                    // Content 3
                    Box(
                        modifier = Modifier
                            .size(150.dp, 179.dp)
                            .background(Color.White)
                            .padding(
                                start = 12.dp,
                                end = 12.dp,
                                top = 12.dp,
                                bottom = 7.dp
                            ),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.item_1),
                                contentDescription = "Voucher 1",
                                modifier = Modifier
                                    .size(126.dp, 107.dp)
                                    .clip(RoundedCornerShape(2.dp))
                            )

                            Spacer(modifier = Modifier.padding(top = 4.dp))

                            Text(
                                text = "Item 1",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color(0xFF626262)
                            )

                            Row(
                                modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                // Add to Cart Box
                                Box(
                                    modifier = Modifier
                                        .size(40.dp, 19.dp)
                                        .background(
                                            Color(0xFF7ACAC7),
                                            shape = RoundedCornerShape(1.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Add",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.White
                                    )
                                }

                                // Item Price
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "15",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = Color(0xFF626262)
                                    )

                                    Spacer(modifier = Modifier.padding(start = 4.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.item_price_icon),
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(start = 30.dp))

                    // Content 4
                    Box(
                        modifier = Modifier
                            .size(150.dp, 179.dp)
                            .background(Color.White)
                            .padding(
                                start = 12.dp,
                                end = 12.dp,
                                top = 12.dp,
                                bottom = 7.dp
                            ),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.item_2),
                                contentDescription = "Voucher 1",
                                modifier = Modifier
                                    .size(126.dp, 107.dp)
                                    .clip(RoundedCornerShape(2.dp))
                            )

                            Spacer(modifier = Modifier.padding(top = 4.dp))

                            Text(
                                text = "Item 2",
                                fontFamily = CustomFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color(0xFF626262)
                            )

                            Row(
                                modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                // Add to Cart Box
                                Box(
                                    modifier = Modifier
                                        .size(40.dp, 19.dp)
                                        .background(
                                            Color(0xFF7ACAC7),
                                            shape = RoundedCornerShape(1.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Add",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp,
                                        color = Color.White
                                    )
                                }

                                // Item Price
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "15",
                                        fontFamily = CustomFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = Color(0xFF626262)
                                    )

                                    Spacer(modifier = Modifier.padding(start = 4.dp))

                                    Image(
                                        painter = painterResource(id = R.drawable.item_price_icon),
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
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

@Preview
@Composable
private fun ExchangeShopHeader() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Exchange Shop",
            fontFamily = CustomFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 26.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.padding(top = 9.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Search Box
            Box(
                modifier = Modifier
                    .size(315.dp, 48.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.White),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.padding(
                        start = 15.dp,
                        end = 15.dp,
                        top = 9.dp,
                        bottom = 9.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Search...",
                        fontFamily = CustomFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color(0xFF9D9D9D)
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }

            // Cart Box
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cart_icon),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
    }
}