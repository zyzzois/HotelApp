package com.example.reservation.domain.repository

import com.example.reservation.domain.entity.ReservationInfo

interface ReservationRepository {
    suspend fun getReservationInfo(): ReservationInfo
}