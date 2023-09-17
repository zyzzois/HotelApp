package com.example.apartments.di

import com.example.apartments.domain.repository.ApartmentsRepository
import kotlin.properties.Delegates

interface ApartmentsDependencies {
    val apartmentsRepository: ApartmentsRepository
}

interface ApartmentsDependenciesProvider {
    val dependencies: ApartmentsDependencies
    companion object : ApartmentsDependenciesProvider by ApartmentsDependenciesStore
}

object ApartmentsDependenciesStore: ApartmentsDependenciesProvider {
    override var dependencies: ApartmentsDependencies by Delegates.notNull()
}
