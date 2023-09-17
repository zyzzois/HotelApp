package com.example.apartments.data.network

import com.example.apartments.data.network.model.RoomsDto
import retrofit2.http.GET

interface ApartmentsApiService {

    @GET("/v3/f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getApartmentsList(): RoomsDto

}