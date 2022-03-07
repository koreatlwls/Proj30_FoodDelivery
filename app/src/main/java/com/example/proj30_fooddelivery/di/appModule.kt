package com.example.proj30_fooddelivery.di

import com.example.proj30_fooddelivery.data.repository.DefaultRestaurantRepository
import com.example.proj30_fooddelivery.data.repository.RestaurantRepository
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

    viewModel { HomeViewModel() }
    viewModel { MyViewModel() }
    viewModel { (restaurantCategory: RestaurantCategory) ->
        RestaurantListViewModel(
            restaurantCategory,
            get()
        )
    }

    single<RestaurantRepository> { DefaultRestaurantRepository(get(), get()) }

    single { provideGsonConvertFactory() }
    single { buildOkHttpClient() }
    single { provideRetrofit(get(), get()) }

    single<ResourcesProvider> { DefaultResourcesProvider(androidApplication()) }

    single { Dispatchers.IO }
    single { Dispatchers.Main }
}