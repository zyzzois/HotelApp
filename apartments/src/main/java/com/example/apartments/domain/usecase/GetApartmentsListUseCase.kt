package com.example.apartments.domain.usecase

import com.example.apartments.domain.entity.ApartmentEntity
import com.example.apartments.domain.repository.ApartmentsRepository
import javax.inject.Inject

class GetApartmentsListUseCase @Inject constructor(
    private val repository: ApartmentsRepository
) {
    suspend operator fun invoke(): List<ApartmentEntity> {
        return repository.getApartmentsListUseCase()
    }
}