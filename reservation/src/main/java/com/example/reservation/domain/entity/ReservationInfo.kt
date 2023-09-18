package com.example.reservation.domain.entity

data class ReservationInfo(
    val id: Int = 1,
    val hotelName: String = "Лучший пятизвездочный отель в Хургаде, Египет",
    val hotelAddress: String =  "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
    val hotelRating: Int = 5,
    val ratingName: String = "Превосходно",
    val departure: String = "Москва",
    val arrivalCountry: String = "Египет, Хургада",
    val tourDateStart: String =  "19.09.2023",
    val tourDateStop: String =  "27.09.2023",
    val numberOfNights: Int = 7,
    val roomDescription: String = "Люкс номер с видом на море",
    val nutrition: String = "Все включено",
    val tourPrice: Int = 289400,
    val fuelCharge: Int = 9300,
    val serviceCharge: Int = 2150
)
