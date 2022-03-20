package com.example.proj30_fooddelivery.data.entity.order

import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantFoodEntity

data class OrderEntity(
    val id: String,
    val userId: String,
    val restaurantId: Long,
    val foodMenuList: List<RestaurantFoodEntity>,
    val restaurantTitle: String
)