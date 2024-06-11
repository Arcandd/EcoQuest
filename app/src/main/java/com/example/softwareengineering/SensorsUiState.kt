package com.example.softwareengineering

data class SensorsUiState(
    // Monitor
    val airTemperature: Double = 0.0,
    val soilHumidity: Int = 0,

    // Control
    val wateringSystemPower: Boolean = false,
    val airConditionerPower: Boolean = false,

    // AC Thresholds
    val lowThreshold: Double = 0.0,
    val highThreshold: Double = 0.0,

    // Water System Thresholds
    val wateringThreshold: Double = 0.0,
)
