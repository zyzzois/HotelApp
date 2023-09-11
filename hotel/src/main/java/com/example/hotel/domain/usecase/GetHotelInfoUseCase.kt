package com.example.hotel.domain.usecase

import com.example.hotel.domain.repository.HotelRepository
import javax.inject.Inject

class GetHotelInfoUseCase @Inject constructor(private val  repository: HotelRepository) {
    suspend operator fun invoke() = repository.getHotelInfo()
}