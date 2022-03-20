package com.example.proj30_fooddelivery.data.repository.restaurant.review

interface RestaurantReviewRepository {

    suspend fun getReviews(restaurantTitle: String): DefaultRestaurantReviewRepository.Result

}