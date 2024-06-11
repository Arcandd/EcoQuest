package com.example.softwareengineering

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QuestProgressBar(
    progress: Float
) {
    CustomProgressBarPreview(progress)
}

@Composable
private fun CustomProgressBarPreview(
    progress: Float
) {
    var progressBar by remember {
        mutableFloatStateOf(progress)
    }
    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        ), label = ""
    )

    Column(
        modifier = Modifier
            .fillMaxSize().padding(horizontal = 4.dp)
    ) {
        // Text above the bar
        Row(
            modifier = Modifier
                .widthIn(min = 30.dp)
                .fillMaxWidth(size),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "${progress * 100}%")
        }

        // Progress Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        ) {
            // Progress bar background
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(0.dp))
                    .background(Color.White)
            )

            // Progress bar progress
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(0.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFFF9B3E), Color(0xFFFFC700)
                            ), start = Offset(120f, 0f),
                            end = Offset(0f, 0f)
                        )
                    )
                    .animateContentSize()
            )
        }
    }

    LaunchedEffect(key1 = true) {
        progressBar = progress
    }
}
