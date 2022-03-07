package com.example.proj30_fooddelivery.data.repository

import com.example.proj30_fooddelivery.data.entity.RestaurantEntity
import com.example.proj30_fooddelivery.screen.main.home.restaurant.RestaurantCategory

interface RestaurantRepository {

    suspend fun getList(
        restaurantCategory: RestaurantCategory
    ):List<RestaurantEntity>
}