package com.example.proj30_fooddelivery.data.repository.map

import com.example.proj30_fooddelivery.data.entity.location.LocationLatLngEntity
import com.example.proj30_fooddelivery.data.response.address.AddressInfo

interface MapRepository {

    suspend fun getReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ): AddressInfo?

}