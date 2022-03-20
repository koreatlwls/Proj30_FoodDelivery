package com.example.proj30_fooddelivery.widget.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.proj30_fooddelivery.data.entity.location.LocationLatLngEntity
import com.example.proj30_fooddelivery.screen.home.restaurant.RestaurantListFragment


class RestaurantListFragmentPagerAdapter(
    fragment: Fragment,
    val fragmentList: List<RestaurantListFragment>,
    var locationLatLng: LocationLatLngEntity
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}