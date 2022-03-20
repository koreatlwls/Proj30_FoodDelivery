package com.example.proj30_fooddelivery.widget.adapter.listener.restaurant

import com.example.proj30_fooddelivery.model.restaurant.RestaurantModel

interface RestaurantLikeListListener: RestaurantListListener {

    fun onDislikeItem(model: RestaurantModel)

}