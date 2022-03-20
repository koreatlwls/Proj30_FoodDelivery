package com.example.proj30_fooddelivery.di

import com.example.proj30_fooddelivery.data.entity.location.LocationLatLngEntity
import com.example.proj30_fooddelivery.data.entity.location.MapSearchInfoEntity
import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantEntity
import com.example.proj30_fooddelivery.data.entity.restaurant.RestaurantFoodEntity
import com.example.proj30_fooddelivery.data.preference.AppPreferenceManager
import com.example.proj30_fooddelivery.data.repository.map.DefaultMapRepository
import com.example.proj30_fooddelivery.data.repository.map.MapRepository
import com.example.proj30_fooddelivery.data.repository.order.DefaultOrderRepository
import com.example.proj30_fooddelivery.data.repository.order.OrderRepository
import com.example.proj30_fooddelivery.data.repository.restaurant.DefaultRestaurantRepository
import com.example.proj30_fooddelivery.data.repository.restaurant.RestaurantRepository
import com.example.proj30_fooddelivery.data.repository.restaurant.food.DefaultRestaurantFoodRepository
import com.example.proj30_fooddelivery.data.repository.restaurant.food.RestaurantFoodRepository
import com.example.proj30_fooddelivery.data.repository.restaurant.review.DefaultRestaurantReviewRepository
import com.example.proj30_fooddelivery.data.repository.restaurant.review.RestaurantReviewRepository
import com.example.proj30_fooddelivery.data.repository.user.DefaultUserRepository
import com.example.proj30_fooddelivery.data.repository.user.UserRepository
import com.example.proj30_fooddelivery.screen.MainViewModel
import com.example.proj30_fooddelivery.screen.home.HomeViewModel
import com.example.proj30_fooddelivery.screen.home.restaurant.RestaurantCategory
import com.example.proj30_fooddelivery.screen.home.restaurant.RestaurantListViewModel
import com.example.proj30_fooddelivery.screen.home.restaurant.detail.RestaurantDetailViewModel
import com.example.proj30_fooddelivery.screen.home.restaurant.detail.menu.RestaurantMenuListViewModel
import com.example.proj30_fooddelivery.screen.home.restaurant.detail.review.RestaurantReviewListViewModel
import com.example.proj30_fooddelivery.screen.like.RestaurantLikeListViewModel
import com.example.proj30_fooddelivery.screen.my.MyViewModel
import com.example.proj30_fooddelivery.screen.mylocation.MyLocationViewModel
import com.example.proj30_fooddelivery.screen.order.OrderMenuListViewModel
import com.example.proj30_fooddelivery.screen.review.gallery.GalleryPhotoRepository
import com.example.proj30_fooddelivery.screen.review.gallery.GalleryViewModel
import com.example.proj30_fooddelivery.util.event.MenuChangeEventBus
import com.example.proj30_fooddelivery.util.provider.DefaultResourcesProvider
import com.example.proj30_fooddelivery.util.provider.ResourcesProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel() }
    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { RestaurantLikeListViewModel(get()) }
    viewModel { MyViewModel(get(), get(), get()) }

    factory { (restaurantCategory: RestaurantCategory, locationLatLngEntity: LocationLatLngEntity) ->
        RestaurantListViewModel(restaurantCategory, locationLatLngEntity, get())
    }

    viewModel { (mapSearchInfoEntity: MapSearchInfoEntity) ->
        MyLocationViewModel(mapSearchInfoEntity, get(), get())
    }

    viewModel { (restaurantEntity: RestaurantEntity) -> RestaurantDetailViewModel(restaurantEntity, get(), get()) }

    viewModel { (restaurantId: Long, restaurantFoodList: List<RestaurantFoodEntity>) ->
        RestaurantMenuListViewModel(restaurantId, restaurantFoodList, get())
    }

    viewModel { (restaurantTitle: String) -> RestaurantReviewListViewModel(restaurantTitle, get()) }

    viewModel { OrderMenuListViewModel(get(), get(), get()) }

    viewModel { GalleryViewModel(get()) }

    single<MapRepository> { DefaultMapRepository(get(), get()) }
    single<RestaurantRepository> { DefaultRestaurantRepository(get(), get(), get()) }
    single<UserRepository> { DefaultUserRepository(get(), get(), get()) }
    single<RestaurantFoodRepository> { DefaultRestaurantFoodRepository(get(), get(), get()) }
    single<OrderRepository> { DefaultOrderRepository(get(), get()) }
    single<RestaurantReviewRepository> { DefaultRestaurantReviewRepository(get(), get()) }
    single { GalleryPhotoRepository(androidApplication()) }

    single { provideGsonConverterFactory() }
    single { buildOkHttpClient() }

    single(named("map")) { provideMapRetrofit(get(), get()) }
    single(named("food")) { provideFoodRetrofit(get(), get()) }

    single { provideMapApiService(get(qualifier = named("map"))) }
    single { provideFoodApiService(get(qualifier = named("food"))) }

    single { provideDB(androidApplication()) }
    single { provideLocationDao(get()) }
    single { provideFoodMenuBasketDao(get()) }
    single { provideRestaurantDao(get()) }

    single<ResourcesProvider> { DefaultResourcesProvider(androidApplication()) }
    single { AppPreferenceManager(androidContext()) }

    single { MenuChangeEventBus() }

    single { Dispatchers.IO }
    single { Dispatchers.Main }

    single { Firebase.firestore }
    single { Firebase.storage }
    single { FirebaseAuth.getInstance() }

}