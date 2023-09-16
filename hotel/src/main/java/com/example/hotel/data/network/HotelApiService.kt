package com.example.hotel.data.network

import com.example.hotel.data.network.model.HotelInfoDto
import retrofit2.http.GET

interface HotelApiService {

    @GET("/v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotelInfo(): HotelInfoDto

}