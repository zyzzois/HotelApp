package com.example.reservation.data.repository

import com.example.reservation.data.mapper.ReservationMapper
import com.example.reservation.data.network.ReservationApiService
import com.example.reservation.domain.repository.ReservationRepository
import javax.inject.Inject

class ReservationRepositoryImpl @Inject constructor(
    private val mapper: ReservationMapper,
    private val apiService: ReservationApiService
): ReservationRepository {

    override suspend fun getReservationInfo() = mapper.mapDtoToEntity(apiService.getReservationInfo())

}