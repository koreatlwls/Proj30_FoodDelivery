package com.example.proj30_fooddelivery.data.entity.location

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class LocationLatLngEntity(
    val latitude: Double,
    val longitude: Double,
    @PrimaryKey(autoGenerate = true)
    val id: Long = -1,
): Parcelable {

    override fun equals(other: Any?): Boolean {
        return if (other is LocationLatLngEntity) {
            (latitude == other.latitude
                    && longitude == other.longitude)
        } else {
            this === other
        }
    }

}