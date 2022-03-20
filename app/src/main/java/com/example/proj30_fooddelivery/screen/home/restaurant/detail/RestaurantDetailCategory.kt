package com.example.proj30_fooddelivery.screen.home.restaurant.detail

import androidx.annotation.StringRes
import com.example.proj30_fooddelivery.R

enum class RestaurantDetailCategory(
    @StringRes val categoryNameId: Int
) {

    MENU(R.string.menu), REVIEW(R.string.review)

}