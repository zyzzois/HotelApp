package com.example.apartments.data.mapper

import com.example.apartments.data.network.model.Room
import com.example.apartments.domain.entity.ApartmentEntity
import javax.inject.Inject

class ApartmentsMapper @Inject constructor() {

    fun mapDtoToEntity(dto: List<Room>): List<ApartmentEntity> {
        return dto.map { mapRoomDtoToEntity(it) }
    }

    private fun mapRoomDtoToEntity(roomDto: Room) = ApartmentEntity(
        id = roomDto.id,
        imageUrls = roomDto.image_urls,
        name = roomDto.name,
        peculiarities = roomDto.peculiarities,
        price = roomDto.price,
        priceDescription = roomDto.price_per
    )
}