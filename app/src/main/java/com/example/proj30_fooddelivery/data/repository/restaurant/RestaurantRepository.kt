package com.example.proj30_fooddelivery.data.repository.restaurant

import com.example.proj30_fooddelivery.data.entity.location.LocationLatLngEntity
import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantEntity
import com.example.proj30_fooddelivery.screen.home.restaurant.RestaurantCategory

interface RestaurantRepository {

    suspend fun getList(
        restaurantCategory: RestaurantCategory,
        locationLatLngEntity: LocationLatLngEntity
    ): List<RestaurantEntity>

}