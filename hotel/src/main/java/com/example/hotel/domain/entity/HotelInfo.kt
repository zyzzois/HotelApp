package com.example.hotel.domain.entity

data class HotelInfo(
    val id: Int,
    val name: String,
    val address: String,
    val minimalPrice: Int,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val hotelImages: List<String>,
    val detailInfo: Pair<String, List<String>>
)
