package com.example.reservation.di

import com.example.reservation.presentation.ReservationViewModel
import dagger.Component
import javax.inject.Scope

@ReservationScope
@Component(
    dependencies = [
        ReservationDependencies::class
    ]
)
interface ReservationComponent {

    fun getReservationViewModel(): ReservationViewModel

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: ReservationDependencies): Builder
        fun build(): ReservationComponent
    }

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ReservationScope

