package com.example.spaceapp.viewmodel

import com.example.spaceapp.repository.DataPhotoDay

sealed class AppState {
    data class Success(val dataPhotoDay: DataPhotoDay) : AppState()
    data class Error(val throwable: Throwable) : AppState()
    object Loading : AppState()
}