package com.example.proj30_fooddelivery.widget.adapter.listener.restaurant

import com.example.proj30_fooddelivery.model.restaurant.FoodModel
import com.example.proj30_fooddelivery.widget.adapter.listener.AdapterListener

interface FoodMenuListListener: AdapterListener {

    fun onClickItem(model: FoodModel)

}