package com.example.hotelapp

import android.app.Application
import com.example.apartments.di.ApartmentsDependenciesStore
import com.example.hotel.di.HotelDependenciesStore
import com.example.hotelapp.di.DaggerAppComponent
import com.example.reservation.di.ReservationDependenciesStore

class App: Application() {

    private val appComponent by lazy {
         DaggerAppComponent.builder()
        .application(this)
        .build()
    }

    override fun onCreate() {
        super.onCreate()
        HotelDependenciesStore.dependencies = appComponent
        ApartmentsDependenciesStore.dependencies = appComponent
        ReservationDependenciesStore.dependencies = appComponent
    }

}