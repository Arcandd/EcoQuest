package com.example.softwareengineering

import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.softwareengineering.ui.theme.CustomFontFamily
import kotlin.math.roundToInt

//@Preview(showBackground = true, backgroundColor = 0xFF304560, heightDp = 2000)
@Composable
fun SensorsScreen(
    modifier: Modifier = Modifier,
    sensorsViewModel: SensorsViewModel = viewModel()
) {
    val uiState by sensorsViewModel.uiState.collectAsState()
    val scrollState = remember {
        ScrollState(0)
    }
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
        modifier = modifier
            .padding(18.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.padding(top = 56.dp))

        // Profile Header
        SensorPageProfileHeader()

        Spacer(modifier = Modifier.padding(24.dp))

        // Sensors
        SensorControl(
            acChecked = uiState.airConditionerPower,
            waterChecked = uiState.wateringSystemPower,
            onACCheckedChange = { isChecked ->
                sensorsViewModel.writeToDatabase(
                    sensorsViewModel.airConditionerPowerRef, isChecked
                )
            },
            onWaterCheckedChange = { isChecked ->
                sensorsViewModel.writeToDatabase(
                    sensorsViewModel.wateringSystemPowerRef, isChecked
                )
            }
        )

        Spacer(modifier = Modifier.padding(16.dp))

        SoilMonitor(
            soilHumidity = uiState.soilHumidity,
            initialThreshold = uiState.wateringThreshold,
            onThresholdChange = {
                sensorsViewModel.writeToDatabase(
                    sensorsViewModel.wateringThresholdRef, it
                )
            }
        )
        Spacer(modifier = Modifier.padding(16.dp))

        ACControl(
            temperature = uiState.airTemperature,
            initialLowThreshold = uiState.lowThreshold,
            initialHighThreshold = uiState.highThreshold,
            onLowThresholdChange = {
                sensorsViewModel.writeToDatabase(
                    sensorsViewModel.lowThresholdRef, it.roundToInt()
                )
            },
            onHighThresholdChange = {
                sensorsViewModel.writeToDatabase(
                    sensorsViewModel.highThresholdRef, it.roundToInt()
                )
            }
        )

        Spacer(modifier = Modifier.padding(top = 132.dp))
    }
}

@Preview
@Composable
private fun SensorPageProfileHeader() {
    // Profile Picture
    Row(
        modifier = Modifier.fillMaxWidth(),
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

        // Header: Your Sensors
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Your Sensors",
                fontFamily = CustomFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 26.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier,
    username: String,
    rank: Int,
) {
    Row(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(50))
                .border(
                    1.dp, Color.White, RoundedCornerShape(50)
                )
        )
        Column(
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(
                text = username,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                text = "Rank $rank",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    username: String,
    rank: Int,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProfileSection(
            modifier = modifier,
            username = username,
            rank = rank
        )

        Text(
            text = "Your Sensors",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}

@Composable
fun SensorCard(
    modifier: Modifier = Modifier,
    sensorName: String,
    checked: Boolean,
    backgroundColor: Brush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF72B1DF), Color(0xFF005C97))
    ),
    backgroundIcon: Int = R.drawable.ac_background,
    thumbColor: Color,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    var checkedState by remember {
        mutableStateOf(checked)
    }

    LaunchedEffect(key1 = checked) {
        checkedState = checked
    }

    Box(
        modifier = modifier
            .shadow(8.dp, shape = RoundedCornerShape(8.dp))
            .background(backgroundColor)
    ) {
        Image(
            painter = painterResource(id = backgroundIcon),
            contentDescription = "bg_icon",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(68.dp) // Adjust size as needed
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Text(
                text = sensorName,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f)) // Spacer to push the switch to the bottom
            Switch(
                checked = checkedState,
                onCheckedChange = {
                    checkedState = it
                    onCheckedChange(it)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = thumbColor,
                    checkedTrackColor = Color.White.copy(alpha = 0.5f),
                    uncheckedThumbColor = Color.LightGray,
                    uncheckedTrackColor = Color.White.copy(alpha = 0.5f)
                ),
            )
        }
    }
}


@Composable
fun SensorControl(
    modifier: Modifier = Modifier,
    waterChecked: Boolean,
    acChecked: Boolean,
    onWaterCheckedChange: (Boolean) -> Unit,
    onACCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        // Water
        SensorCard(
            modifier = Modifier.weight(1f),
            sensorName = "Watering System",
            checked = waterChecked,
            backgroundColor = Brush.horizontalGradient(
                0f to Color(0xFF72B1DF),
                1f to Color(0XFF256081)
            ),
            backgroundIcon = R.drawable.thermometer,
            thumbColor = Color(0xFF5476AA),
            onCheckedChange = onWaterCheckedChange
        )
        // AC
        SensorCard(
            modifier = Modifier.weight(1f),
            sensorName = "Air Conditioner",
            checked = acChecked,
            backgroundColor = Brush.horizontalGradient(
                0f to Color(0xFF4AC188),
                1f to Color(0XFF2D7D57)
            ),
            backgroundIcon = R.drawable.ac_background,
            thumbColor = Color(0xFF238C73),
            onCheckedChange = onACCheckedChange
        )
    }
}

@Composable
fun MonitorHeader(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String,
    sensorName: String
) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
        Text(text = sensorName, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun Gauge(
    initialValue: Double,
    modifier: Modifier = Modifier,
    primaryColor: Color,
    secondaryColor: Color,
    minValue: Int = 0,
    maxValue: Int = 100,
    circleRadius: Float,
    unit: String = "°C"
) {
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var positionValue by remember {
        mutableDoubleStateOf(initialValue)
    }

    positionValue = initialValue

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxWidth()) {
            val width = size.width
            val height = size.height
            val outerCircleThickness = width / 17.5f
            circleCenter = Offset(x = width / 2f, y = height / 2f)

            drawCircle(
                radius = circleRadius,
                center = circleCenter,
                color = Color.White
            )

            drawCircle(
                style = Stroke(
                    width = outerCircleThickness
                ),
                color = secondaryColor, radius = circleRadius, center = circleCenter
            )

            drawCircle(
                style = Stroke(
                    width = outerCircleThickness * 0.3f
                ),
                color = Color.White,
                radius = circleRadius + outerCircleThickness * 0.7f,
                center = circleCenter
            )

            drawArc(
                color = primaryColor,
                startAngle = 270f,
                sweepAngle = (360f / maxValue) * positionValue.toFloat(),
                style = Stroke(
                    width = outerCircleThickness, cap = StrokeCap.Square
                ),
                useCenter = false,
                size = Size(
                    width = circleRadius * 2f, height = circleRadius * 2f
                ),
                topLeft = Offset(
                    (width - circleRadius * 2f) / 2f, (height - circleRadius * 2f) / 2f
                )
            )

            drawContext.canvas.nativeCanvas.apply {
                drawIntoCanvas {
                    drawText("$positionValue$unit",
                        circleCenter.x,
                        circleCenter.y + 30.dp.toPx() / 3f,
                        Paint().apply {
                            textSize = 24.sp.toPx()
                            textAlign = Paint.Align.CENTER
                            color = Color(0XFF5C7B86).toArgb()
                            isFakeBoldText = false
                        })
                }
            }
        }
    }
}

@Composable
fun ThresholdCard(
    modifier: Modifier = Modifier,
    threshold: Double,
    onThresholdChange: (Double) -> Unit,
    title: String,
    minValue: Float,
    maxValue: Float,
    metrics: String
) {
    // Local state for the slider value
    var sliderValue by remember { mutableFloatStateOf(threshold.toFloat()) }
    var isDragging by remember { mutableStateOf(false) }

    // Update the slider value only when the threshold changes from props
    LaunchedEffect(threshold) {
        if (!isDragging) {
            sliderValue = threshold.toFloat()
        }
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .border(
                1.dp, Color.LightGray, RoundedCornerShape(8.dp)
            )
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "${sliderValue.toInt()}$metrics",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp, bottom = 2.dp)
        )
        Slider(
            value = sliderValue,
            onValueChange = {
                sliderValue = it
                isDragging = true
            },
            onValueChangeFinished = {
                isDragging = false
                onThresholdChange(sliderValue.toDouble())
            },
            valueRange = minValue..maxValue,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF1E435E),
                activeTrackColor = Color(0xFF1E435E),
                inactiveTrackColor = Color.LightGray
            )
        )
    }
}

@Composable
fun SoilMonitor(
    modifier: Modifier = Modifier,
    soilHumidity: Int,
    initialThreshold: Double,
    onThresholdChange: (Double) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                16.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                5.dp, Color.White, RoundedCornerShape(8.dp)
            )
            .background(Color(0XFFD4FAFA))
            .padding(16.dp)
    ) {
        MonitorHeader(
            icon = R.drawable.plant_icon,
            title = "Soil Monitor",
            sensorName = "Humidity Sensor"
        )
        Gauge(
            initialValue = soilHumidity.toDouble(),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            primaryColor = Color(0xFF00C853),
            secondaryColor = Color(0xFFB2DFDB),
            circleRadius = 200f,
            unit = "%"
        )
        ThresholdCard(
            threshold = initialThreshold,
            onThresholdChange = onThresholdChange,
            title = "Water Threshold",
            minValue = 0f,
            maxValue = 100f,
            metrics = "%"
        )
    }
}


@Composable
fun ACControl(
    modifier: Modifier = Modifier,
    temperature: Double,
    initialLowThreshold: Double,
    initialHighThreshold: Double,
    onLowThresholdChange: (Double) -> Unit,
    onHighThresholdChange: (Double) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                16.dp,
                shape = RoundedCornerShape(8.dp),

                )
            .border(
                5.dp, Color.White, RoundedCornerShape(8.dp)
            )
            .background(Color(0XFFFAF6D4))
            .padding(16.dp)
    ) {
        MonitorHeader(
            icon = R.drawable.ac_icon,
            title = "AC Control",
            sensorName = "DHT11 Temperature Sensor",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Gauge(
            initialValue = temperature,
            primaryColor = Color(0xFFFF9800),
            secondaryColor = Color(0xFFB2DFDB),
            circleRadius = 200f,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            minValue = 10,
            maxValue = 50
        )
        ThresholdCard(
            threshold = initialLowThreshold,
            onThresholdChange = onLowThresholdChange,
            title = "Low Threshold",
            minValue = 0f,
            maxValue = 50f,
            metrics = "°C"
        )
        Spacer(modifier = Modifier.padding(8.dp))
        ThresholdCard(
            threshold = initialHighThreshold,
            onThresholdChange = onHighThresholdChange,
            title = "High Threshold",
            minValue = 0f,
            maxValue = 50f,
            metrics = "°C"
        )
    }
}
