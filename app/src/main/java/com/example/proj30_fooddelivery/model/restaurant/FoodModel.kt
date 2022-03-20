package com.example.proj30_fooddelivery.model.restaurant

import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantFoodEntity
import com.example.proj30_fooddelivery.model.CellType
import com.example.proj30_fooddelivery.model.Model

data class FoodModel(
    override val id: Long,
    override val type: CellType = CellType.FOOD_CELL,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    val restaurantId: Long,
    val foodId: String,
    val restaurantTitle: String
) : Model(id, type) {

    fun toEntity(basketIndex: Int) = RestaurantFoodEntity(
        "${foodId}_${basketIndex}", title, description, price, imageUrl, restaurantId, restaurantTitle
    )

}