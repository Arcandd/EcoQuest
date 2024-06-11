package com.example.softwareengineering

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuestViewModel: ViewModel() {
    // Backing Property
    private val _uiState = MutableStateFlow(QuestUiState())
    val uiState: StateFlow<QuestUiState> = _uiState.asStateFlow()

    fun addProgress(amount: Float, coins: Int){
        if(_uiState.value.progress >= 100.0f){
            Log.d("QuestViewModel", "Progress is already at 100")
            return
        }else{
            _uiState.value = _uiState.value.copy(progress = _uiState.value.progress + amount)
        }

        _uiState.value = _uiState.value.copy(coins = _uiState.value.coins + coins)

        Log.d("QuestViewModel", "Progress updated to ${_uiState.value.progress}")
        Log.d("QuestViewModel", "Coins updated to ${_uiState.value.coins}")
    }
}