package com.example.proj30_fooddelivery.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proj30_fooddelivery.data.db.dao.FoodMenuBasketDao
import com.example.proj30_fooddelivery.data.db.dao.LocationDao
import com.example.proj30_fooddelivery.data.db.dao.RestaurantDao
import com.example.proj30_fooddelivery.data.entity.location.LocationLatLngEntity
import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantEntity
import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantFoodEntity

@Database(
    entities = [LocationLatLngEntity::class, RestaurantFoodEntity::class, RestaurantEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ApplicationDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "ApplicationDataBase.db"
    }

    abstract fun LocationDao(): LocationDao

    abstract fun FoodMenuBasketDao(): FoodMenuBasketDao

    abstract fun RestaurantDao(): RestaurantDao

}