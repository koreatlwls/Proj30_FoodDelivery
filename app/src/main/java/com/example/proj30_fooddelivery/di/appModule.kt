package com.example.proj30_fooddelivery.di

import com.example.proj30_fooddelivery.data.repository.map.DefaultMapRepository
import com.example.proj30_fooddelivery.data.repository.map.MapRepository
import com.example.proj30_fooddelivery.data.repository.restaurant.DefaultRestaurantRepository
import com.example.proj30_fooddelivery.data.repository.restaurant.RestaurantRepository
import com.example.proj30_fooddelivery.screen.main.home.HomeViewModel
import com.example.proj30_fooddelivery.screen.main.home.restaurant.RestaurantCategory
import com.example.proj30_fooddelivery.screen.main.home.restaurant.RestaurantListViewModel
import com.example.proj30_fooddelivery.screen.main.my.MyViewModel
import com.example.proj30_fooddelivery.util.provider.DefaultResourcesProvider
import com.example.proj30_fooddelivery.util.provider.ResourcesProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { HomeViewModel(get()) }
    viewModel { MyViewModel() }
    viewModel { (restaurantCategory: RestaurantCategory) ->
        RestaurantListViewModel(
            restaurantCategory,
            get()
        )
    }

    single<RestaurantRepository> { DefaultRestaurantRepository(get(), get()) }
    single<MapRepository> {DefaultMapRepository(get(), get())}

    single { provideGsonConvertFactory() }
    single { buildOkHttpClient() }
    single { provideMapRetrofit(get(), get()) }

    single { provideMapApiService(get())}

    single<ResourcesProvider> { DefaultResourcesProvider(androidApplication()) }

    single { Dispatchers.IO }
    single { Dispatchers.Main }
}