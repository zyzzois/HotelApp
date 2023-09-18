package com.example.reservation.domain.usecase

import com.example.reservation.domain.repository.ReservationRepository
import javax.inject.Inject

class GetReservationInfoUseCase @Inject constructor(
    private val repository: ReservationRepository
) {
    suspend operator fun invoke() = repository.getReservationInfo()
}