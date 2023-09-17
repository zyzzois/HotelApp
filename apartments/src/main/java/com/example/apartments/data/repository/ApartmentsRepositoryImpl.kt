package com.example.apartments.data.repository

import android.util.Log
import com.example.apartments.data.mapper.ApartmentsMapper
import com.example.apartments.data.network.ApartmentsApiService
import com.example.apartments.domain.entity.ApartmentEntity
import com.example.apartments.domain.repository.ApartmentsRepository
import java.lang.RuntimeException
import javax.inject.Inject

class ApartmentsRepositoryImpl @Inject constructor(
    private val apiService: ApartmentsApiService,
    private val mapper: ApartmentsMapper
): ApartmentsRepository {

    override suspend fun getApartmentsListUseCase(): List<ApartmentEntity> {
        try {
            val res = apiService.getApartmentsList().rooms
            return mapper.mapDtoToEntity(res)
        } catch (e: Exception) {
            throw RuntimeException("Data from server is null!")
        }
    }

}