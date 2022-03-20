package com.example.proj30_fooddelivery.screen.mylocation

import com.example.proj30_fooddelivery.data.entity.location.MapSearchInfoEntity

sealed class MyLocationState {

    object Uninitialized : MyLocationState()

    object Loading : MyLocationState()

    data class Success(
        val mapSearchInfoEntity: MapSearchInfoEntity
    ) : MyLocationState()

    data class Confirm(
        val mapSearchInfoEntity: MapSearchInfoEntity
    ) : MyLocationState()

}