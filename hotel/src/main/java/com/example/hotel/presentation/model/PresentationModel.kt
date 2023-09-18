package com.example.hotel.presentation.model

import android.widget.TextView
import com.denzcoskun.imageslider.models.SlideModel

data class PresentationModel(
    val hotelImages: List<SlideModel>,
    val hotelRating: String,
    val hotelName: String,
    val hotelLocation: String,
    val price: HotelPrice,
    val chips: List<TextView>,
    val description: String
)

data class HotelPrice(
    val price: String,
    val description: String
)