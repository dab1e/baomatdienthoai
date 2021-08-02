package com.dab1e.bomtcucgi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScreenLockViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ScreenLockViewModel::class.java)){
            return ScreenLockViewModel() as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}