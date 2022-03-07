package com.example.proj30_fooddelivery.screen.main.home.restaurant

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proj30_fooddelivery.data.entity.RestaurantEntity
import com.example.proj30_fooddelivery.data.repository.RestaurantRepository
import com.example.proj30_fooddelivery.screen.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RestaurantListViewModel(
    private val restaurantCategory: RestaurantCategory,
    private val restaurantRepository: RestaurantRepository
):BaseViewModel() {

    val restaurantListLiveData = MutableLiveData<List<RestaurantEntity>>()

    override fun fetchData(): Job = viewModelScope.launch{
        val restaurantList = restaurantRepository.getList(restaurantCategory)
        restaurantListLiveData.value = restaurantList
    }
}