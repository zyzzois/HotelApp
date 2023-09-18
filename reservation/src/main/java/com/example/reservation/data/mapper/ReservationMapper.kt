package com.example.reservation.data.mapper

import com.example.reservation.data.network.ReservationInfoDto
import com.example.reservation.domain.entity.ReservationInfo
import javax.inject.Inject

class ReservationMapper @Inject constructor() {

    fun mapDtoToEntity(dto: ReservationInfoDto) = ReservationInfo(
        id = dto.id,
        hotelName = dto.hotel_name,
        hotelAddress = dto.hotel_adress,
        hotelRating = dto.horating,
        ratingName = dto.rating_name,
        departure = dto.departure,
        arrivalCountry = dto.arrival_country,
        tourDateStart = dto.tour_date_start,
        tourDateStop = dto.tour_date_stop,
        numberOfNights = dto.number_of_nights,
        roomDescription = dto.room,
        nutrition = dto.nutrition,
        tourPrice = dto.tour_price,
        fuelCharge = dto.fuel_charge,
        serviceCharge = dto.service_charge
    )

}