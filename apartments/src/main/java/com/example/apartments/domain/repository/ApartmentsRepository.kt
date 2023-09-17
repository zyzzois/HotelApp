package com.example.apartments.domain.repository

import com.example.apartments.domain.entity.ApartmentEntity

interface ApartmentsRepository {
    suspend fun getApartmentsListUseCase(): List<ApartmentEntity>
}