package com.example.proj30_fooddelivery.util.event

import com.example.proj30_fooddelivery.screen.MainTabMenu
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class MenuChangeEventBus {
    private val _mainTabMenuFlow = MutableSharedFlow<MainTabMenu>()
    val mainTabMenuFlow = _mainTabMenuFlow.asSharedFlow()

    suspend fun changeMenu(event: MainTabMenu) {
        _mainTabMenuFlow.emit(event)
    }
}