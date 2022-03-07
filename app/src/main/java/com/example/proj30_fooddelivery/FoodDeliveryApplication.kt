package com.example.proj30_fooddelivery

import android.app.Application
import android.content.Context
import com.example.proj30_fooddelivery.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoodDeliveryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this

        startKoin {
            androidContext(this@FoodDeliveryApplication)
            modules(appModule)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        appContext = null
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}