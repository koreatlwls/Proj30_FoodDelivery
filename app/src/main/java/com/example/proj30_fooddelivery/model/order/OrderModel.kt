package com.example.proj30_fooddelivery.model.order

import com.example.proj30_fooddelivery.data.entity.order.OrderEntity
import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantFoodEntity
import com.example.proj30_fooddelivery.model.CellType
import com.example.proj30_fooddelivery.model.Model

data class OrderModel(
    override val id: Long,
    override val type: CellType = CellType.ORDER_CELL,
    val orderId: String,
    val userId: String,
    val restaurantId: Long,
    val foodMenuList: List<RestaurantFoodEntity>,
    val restaurantTitle: String
): Model(id, type) {

    fun toEntity() = OrderEntity(
        id = orderId,
        userId = userId,
        restaurantId = restaurantId,
        foodMenuList = foodMenuList,
        restaurantTitle = restaurantTitle
    )

}