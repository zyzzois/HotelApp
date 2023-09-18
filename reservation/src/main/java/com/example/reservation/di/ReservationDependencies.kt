package com.example.reservation.di

import com.example.reservation.domain.repository.ReservationRepository
import kotlin.properties.Delegates

interface ReservationDependencies {
    val reservationRepository: ReservationRepository
}

interface ReservationDependenciesProvider {
    val dependencies: ReservationDependencies
    companion object : ReservationDependenciesProvider by ReservationDependenciesStore
}

object ReservationDependenciesStore: ReservationDependenciesProvider {
    override var dependencies: ReservationDependencies by Delegates.notNull()
}
