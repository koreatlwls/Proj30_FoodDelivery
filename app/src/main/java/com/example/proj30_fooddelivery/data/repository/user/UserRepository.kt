package com.example.proj30_fooddelivery.data.repository.user

import com.example.proj30_fooddelivery.data.entity.location.LocationLatLngEntity
import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantEntity


interface UserRepository {

    suspend fun getUserLocation(): LocationLatLngEntity?

    suspend fun insertUserLocation(locationLatLngEntity: LocationLatLngEntity)

    suspend fun getUserLikedRestaurant(restaurantTitle: String): RestaurantEntity?

    suspend fun getAllUserLikedRestaurant(): List<RestaurantEntity>

    suspend fun insertUserLikedRestaurant(restaurantEntity: RestaurantEntity)

    suspend fun deleteUserLikedRestaurant(restaurantTitle: String)

    suspend fun deleteALlUserLikedRestaurant()

}