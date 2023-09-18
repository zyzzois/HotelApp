package com.example.reservation.data.network

import retrofit2.http.GET

interface ReservationApiService {

    @GET("/v3/e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getReservationInfo(): ReservationInfoDto

}