package com.example.proj30_fooddelivery.screen.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proj30_fooddelivery.R
import com.example.proj30_fooddelivery.data.entity.LocationLatLngEntity
import com.example.proj30_fooddelivery.data.repository.map.MapRepository
import com.example.proj30_fooddelivery.screen.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val mapRepository: MapRepository
) : BaseViewModel() {

    val homeStateLiveData = MutableLiveData<HomeState>(HomeState.Uninitialized)

    fun loadReverseGeoInformation(locationLatLngEntity: LocationLatLngEntity) =
        viewModelScope.launch {
            homeStateLiveData.value = HomeState.Loading
            val addressInfo = mapRepository.getReverseGeoInformation(locationLatLngEntity)
            addressInfo?.let { info ->
                homeStateLiveData.value = HomeState.Success(
                    mapSearchInfoEntity = info.toSearchInfoEntity(locationLatLngEntity)
                )
            } ?: kotlin.run {
                homeStateLiveData.value = HomeState.Error(
                    R.string.can_not_load_address_info
                )
            }
        }
}