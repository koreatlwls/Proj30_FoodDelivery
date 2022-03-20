package com.example.proj30_fooddelivery.screen.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proj30_fooddelivery.R
import com.example.proj30_fooddelivery.data.entity.location.LocationLatLngEntity
import com.example.proj30_fooddelivery.data.entity.location.MapSearchInfoEntity
import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantFoodEntity
import com.example.proj30_fooddelivery.data.repository.map.MapRepository
import com.example.proj30_fooddelivery.data.repository.restaurant.food.RestaurantFoodRepository
import com.example.proj30_fooddelivery.data.repository.user.UserRepository
import com.example.proj30_fooddelivery.screen.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val mapRepository: MapRepository,
    private val userRepository: UserRepository,
    private val restaurantFoodRepository: RestaurantFoodRepository
) : BaseViewModel() {

    companion object {
        const val MY_LOCATION_KEY = "MyLocation"
    }

    val homeStateLiveData = MutableLiveData<HomeState>(HomeState.Uninitialized)

    val foodMenuBasketLiveData = MutableLiveData<List<RestaurantFoodEntity>>()

    fun loadReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ) = viewModelScope.launch {
        homeStateLiveData.value = HomeState.Loading
        val userLocation = userRepository.getUserLocation()
        val currentLocation = userLocation ?: locationLatLngEntity

        val addressInfo = mapRepository.getReverseGeoInformation(currentLocation)
        addressInfo?.let { info ->
            homeStateLiveData.value = HomeState.Success(
                MapSearchInfoEntity(
                    fullAddress = info.fullAddress ?: "주소 정보 없음",
                    name = info.buildingName ?: "빌딩정보 없음",
                    locationLatLng = currentLocation
                ),
                isLocationSame = userLocation == locationLatLngEntity
            )
        } ?: kotlin.run {
            homeStateLiveData.value = HomeState.Error(
                messageId = R.string.can_not_load_address_info
            )
        }
    }

    fun getMapSearchInfo(): MapSearchInfoEntity? {
        when (val data = homeStateLiveData.value) {
            is HomeState.Success -> {
                return data.mapSearchInfoEntity
            }
        }
        return null
    }

    fun checkMyBasket() = viewModelScope.launch {
        foodMenuBasketLiveData.value = restaurantFoodRepository.getAllFoodMenuListInBasket()
    }

}