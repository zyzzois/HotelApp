package com.example.hotel.di

import com.example.hotel.presentation.HotelViewModel
import dagger.Component
import javax.inject.Scope

@HotelScope
@Component(
    dependencies = [
        HotelDependencies::class
    ]
)
interface HotelComponent {

    fun getHotelViewModel(): HotelViewModel

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: HotelDependencies): Builder
        fun build(): HotelComponent
    }

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class HotelScope

