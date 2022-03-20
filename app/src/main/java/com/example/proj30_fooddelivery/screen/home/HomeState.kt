package com.example.proj30_fooddelivery.screen.home

import androidx.annotation.StringRes
import com.example.proj30_fooddelivery.data.entity.location.MapSearchInfoEntity
import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantFoodEntity

sealed class HomeState {

    object Uninitialized: HomeState()

    object Loading: HomeState()

    data class Success(
        val mapSearchInfoEntity: MapSearchInfoEntity,
        val isLocationSame: Boolean,
        val foodMenuListInBasket: List<RestaurantFoodEntity>? = null
    ): HomeState()

    data class Error(
        @StringRes val messageId: Int
    ): HomeState()

}