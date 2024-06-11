package com.example.softwareengineering

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var isOverlayShown by mutableStateOf(false)
        private set
    var isPasswordOverlayShown by mutableStateOf(false)
        private set
    var isEmailOverlayShown by mutableStateOf(false)
        private set
    var isPhoneOverlayShown by mutableStateOf(false)
        private set
    var is2FAOverlayShown by mutableStateOf(false)
        private set
    var isLogOutOverlayShown by mutableStateOf(false)
        private set
    var isDeleteAccOverlayShown by mutableStateOf(false)
        private set

    fun onEditUsernameClick() {
        isOverlayShown = true
    }

    fun onEditPasswordClick() {
        isPasswordOverlayShown = true
    }

    fun onEditEmailClick() {
        isEmailOverlayShown = true
    }

    fun onEditPhoneClick() {
        isPhoneOverlayShown = true
    }

    fun on2FAClick() {
        is2FAOverlayShown = true
    }

    fun onLogOutClick() {
        isLogOutOverlayShown = true
    }

    fun onDeleteAccClick() {
        isDeleteAccOverlayShown = true
    }

    fun onDismissOverlay() {
        isOverlayShown = false
        isPasswordOverlayShown = false
        isEmailOverlayShown = false
        isPhoneOverlayShown = false
        is2FAOverlayShown = false
        isLogOutOverlayShown = false
        isDeleteAccOverlayShown = false
    }
}