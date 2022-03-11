package com.example.proj30_fooddelivery.data.repository.map

import com.example.proj30_fooddelivery.data.entity.LocationLatLngEntity
import com.example.proj30_fooddelivery.data.network.MapApiService
import com.example.proj30_fooddelivery.data.response.address.AddressInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefaultMapRepository(
    private val mapApiService: MapApiService,
    private val ioDispatcher: CoroutineDispatcher
) : MapRepository {
    override suspend fun getReverseGeoInformation(locationLatLngEntity: LocationLatLngEntity): AddressInfo? =
        withContext(ioDispatcher) {
            val response = mapApiService.getReverseGeoCode(
                lat = locationLatLngEntity.latitude,
                lon = locationLatLngEntity.longitude
            )
            if (response.isSuccessful) {
                response.body()?.addressInfo
            } else {
                null
            }
        }
}