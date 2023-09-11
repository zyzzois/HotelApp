package com.example.apartments.domain.repository

import com.example.apartments.domain.entity.ApartmentInfo

interface ApartmentsRepository {
    suspend fun getApartmentsListUseCase(): List<ApartmentInfo>
}