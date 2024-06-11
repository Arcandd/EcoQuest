package com.example.softwareengineering

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.round
import kotlin.math.roundToInt

class SensorsViewModel : ViewModel() {
    // Backing State
    private val _uiState = MutableStateFlow(SensorsUiState())
    val uiState: StateFlow<SensorsUiState> = _uiState.asStateFlow()

    // Firebase Reference
    // Singleton
    private val database by lazy { Firebase.database }
    private val tempRef = database.getReference("data/airConditioner/temperature")
    private val soilHumidRef = database.getReference("data/wateringSystem/soilHumidity")
    val wateringSystemPowerRef = database.getReference("data/wateringSystem/power")
    val airConditionerPowerRef = database.getReference("data/airConditioner/power")
    val lowThresholdRef = database.getReference("data/airConditioner/lowThreshold")
    val highThresholdRef = database.getReference("data/airConditioner/highThreshold")
    val wateringThresholdRef = database.getReference("data/wateringSystem/waterThreshold")

    init {
        listenForUpdates()
    }

    private fun addListener(
        ref: DatabaseReference,
        field: String,
        update: (DataSnapshot) -> Unit
    ) {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                update(snapshot)
                Log.d(field, "Value of $field changed to ${snapshot.value}")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(field, "Failed to read value.", error.toException())
            }
        })
    }


    private fun listenForUpdates() {
        addListener(tempRef, "Temperature") { snapshot ->
            val newTemp = snapshot.getValue(Double::class.java) ?: 0.0
            if (_uiState.value.airTemperature != newTemp) {
                _uiState.update { currentState ->
                    currentState.copy(airTemperature = newTemp)
                }
                Log.d("Temperature", "State updated to $newTemp")
            }
        }

        addListener(soilHumidRef, "Soil Humidity") { snapshot ->
            val newHumidity = snapshot.getValue(Int::class.java) ?: 0
            if (_uiState.value.soilHumidity != newHumidity) {
                _uiState.update { currentState ->
                    currentState.copy(soilHumidity = newHumidity)
                }
                Log.d("Soil Humidity", "State updated to $newHumidity")
            }
        }

        addListener(wateringSystemPowerRef, "Watering System Power") { snapshot ->
            val newPower = snapshot.getValue(Boolean::class.java) ?: false
            if (_uiState.value.wateringSystemPower != newPower) {
                _uiState.update { currentState ->
                    currentState.copy(wateringSystemPower = newPower)
                }
                Log.d("Watering System Power", "State updated to $newPower")
            }
        }

        addListener(airConditionerPowerRef, "Air Conditioner Power") { snapshot ->
            val newPower = snapshot.getValue(Boolean::class.java) ?: false
            if (_uiState.value.airConditionerPower != newPower) {
                _uiState.update { currentState ->
                    currentState.copy(airConditionerPower = newPower)
                }
                Log.d("Air Conditioner Power", "State updated to $newPower")
            }
        }

        addListener(lowThresholdRef, "Low Threshold") { snapshot ->
            val newThreshold = snapshot.getValue(Double::class.java) ?: 0.0
            if (_uiState.value.lowThreshold != newThreshold) {
                _uiState.update { currentState ->
                    currentState.copy(lowThreshold = newThreshold.roundToInt().toDouble())
                }
                Log.d("Low Threshold", "State updated to $newThreshold")
            }
        }

        addListener(highThresholdRef, "High Threshold") { snapshot ->
            val newThreshold = snapshot.getValue(Double::class.java) ?: 0.0
            if (_uiState.value.highThreshold != newThreshold) {
                _uiState.update { currentState ->
                    currentState.copy(highThreshold = newThreshold.roundToInt().toDouble())
                }
                Log.d("High Threshold", "State updated to $newThreshold")
            }
        }

        addListener(wateringThresholdRef, "Watering Threshold") { snapshot ->
            val newThreshold = snapshot.getValue(Double::class.java) ?: 0.0
            if (_uiState.value.wateringThreshold != newThreshold) {
                _uiState.update { currentState ->
                    currentState.copy(wateringThreshold = newThreshold)
                }
                Log.d("Watering Threshold", "State updated to $newThreshold")
            }
        }
    }

    fun writeToDatabase(ref: DatabaseReference, value: Any) {
        ref.setValue(value).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("Database", "Value written successfully.")
            } else {
                Log.e("Database", "Failed to write value.", task.exception)
            }
        }
    }
}
