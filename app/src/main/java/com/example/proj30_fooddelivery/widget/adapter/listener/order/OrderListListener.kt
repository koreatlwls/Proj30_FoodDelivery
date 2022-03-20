package com.example.proj30_fooddelivery.widget.adapter.listener.order

import com.example.proj30_fooddelivery.widget.adapter.listener.AdapterListener

interface OrderListListener: AdapterListener {

    fun writeRestaurantReview(orderId: String, restaurantTitle: String)

}