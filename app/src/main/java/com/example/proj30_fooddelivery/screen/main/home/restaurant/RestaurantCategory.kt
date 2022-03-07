package com.example.proj30_fooddelivery.screen.main.home.restaurant

import androidx.annotation.StringRes
import com.example.proj30_fooddelivery.R

enum class RestaurantCategory(
    @StringRes val categoryNameId: Int,
    @StringRes val categoryTypeId: Int
) {
    ALL(R.string.all, R.string.all_type)
}