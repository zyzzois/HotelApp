package com.example.hotelapp.di

import android.app.Application
import com.example.apartments.di.ApartmentsDependencies
import com.example.apartments.di.ApartmentsModule
import com.example.apartments.domain.repository.ApartmentsRepository
import com.example.code_data.di.CoreNetworkModule
import com.example.hotel.di.HotelDependencies
import com.example.hotel.di.HotelModule
import com.example.hotel.domain.repository.HotelRepository
import com.example.reservation.di.ReservationDependencies
import com.example.reservation.di.ReservationModule
import com.example.reservation.domain.repository.ReservationRepository
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        HotelModule::class,
        CoreNetworkModule::class,
        ApartmentsModule::class,
        ReservationModule::class
    ]
)
interface AppComponent: HotelDependencies, ApartmentsDependencies, ReservationDependencies {

    override val hotelRepository: HotelRepository
    override val apartmentsRepository: ApartmentsRepository
    override val reservationRepository: ReservationRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build() : AppComponent
    }

}