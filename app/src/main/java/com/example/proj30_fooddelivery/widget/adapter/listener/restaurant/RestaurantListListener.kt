package com.example.proj30_fooddelivery.widget.adapter.listener.restaurant

import com.example.proj30_fooddelivery.model.restaurant.RestaurantModel
import com.example.proj30_fooddelivery.widget.adapter.listener.AdapterListener

interface RestaurantListListener : AdapterListener{

    fun onClickItem(model: RestaurantModel)
}