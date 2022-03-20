package com.example.proj30_fooddelivery.widget.adapter.listener.order

import com.example.proj30_fooddelivery.model.restaurant.FoodModel
import com.example.proj30_fooddelivery.widget.adapter.listener.AdapterListener

interface OrderMenuListListener: AdapterListener {

    fun onRemoveItem(model: FoodModel)

}