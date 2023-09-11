package com.example.hotel.domain.repository

import com.example.hotel.domain.entity.HotelInfo

interface HotelRepository {
    suspend fun getHotelInfo(): HotelInfo
}