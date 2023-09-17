package com.example.apartments.di

import com.example.apartments.presentation.ApartmentsViewModel
import dagger.Component
import javax.inject.Scope

@ApartmentsScope
@Component(
    dependencies = [
        ApartmentsDependencies::class
    ]
)
interface ApartmentsComponent {

    fun getApartmentsViewModel(): ApartmentsViewModel

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: ApartmentsDependencies): Builder
        fun build(): ApartmentsComponent
    }

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApartmentsScope