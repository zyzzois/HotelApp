package com.example.hotel.di

import com.example.hotel.domain.repository.HotelRepository
import kotlin.properties.Delegates

interface HotelDependencies {
    val hotelRepository: HotelRepository
}

interface HotelDependenciesProvider {
    val dependencies: HotelDependencies
    companion object : HotelDependenciesProvider by HotelDependenciesStore
}

object HotelDependenciesStore: HotelDependenciesProvider {
    override var dependencies: HotelDependencies by Delegates.notNull()
}
