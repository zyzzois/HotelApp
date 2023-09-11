package com.example.hotel.data.mapper

import com.example.hotel.data.network.model.HotelInfoDto
import com.example.hotel.domain.entity.HotelInfo
import javax.inject.Inject

class HotelMapper @Inject constructor() {

    fun mapDtoToEntity(dto: HotelInfoDto) = HotelInfo(
        id = dto.id,
        name = dto.name,
        address = dto.adress,
        minimalPrice = dto.minimal_price,
        priceForIt = dto.price_for_it,
        rating = dto.rating,
        ratingName = dto.rating_name,
        hotelImages = dto.image_urls,
        detailInfo = Pair(dto.about_the_hotel.description, dto.about_the_hotel.peculiarities)
    )

}