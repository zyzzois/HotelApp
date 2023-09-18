package com.example.hotel.data.repository

import com.example.hotel.data.mapper.HotelMapper
import com.example.hotel.data.network.HotelApiService
import com.example.hotel.domain.entity.HotelInfo
import com.example.hotel.domain.repository.HotelRepository
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val mapper: HotelMapper,
    private val hotelApiService: HotelApiService
): HotelRepository {

    override suspend fun getHotelInfo(): HotelInfo {
        val requestResult = hotelApiService.getHotelInfo()
        return mapper.mapDtoToEntity(requestResult)
    }

}