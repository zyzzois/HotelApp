package com.example.hotel.data.repository

import com.example.hotel.data.mapper.HotelMapper
import com.example.hotel.data.network.ApiService
import com.example.hotel.domain.entity.HotelInfo
import com.example.hotel.domain.repository.HotelRepository
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val mapper: HotelMapper,
    private val apiService: ApiService
): HotelRepository {

    override suspend fun getHotelInfo(): HotelInfo {
        val requestResult = apiService.getHotelInfo()
        return mapper.mapDtoToEntity(requestResult)
    }

}