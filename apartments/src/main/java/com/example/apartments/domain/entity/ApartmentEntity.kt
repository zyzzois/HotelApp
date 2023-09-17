package com.example.apartments.domain.entity

data class ApartmentEntity(
    val id: Int,
    val imageUrls: List<String>,
    val name: String,
    val peculiarities: List<String>,
    val price: Int,
    val priceDescription: String
)
