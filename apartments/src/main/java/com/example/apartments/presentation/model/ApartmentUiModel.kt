package com.example.apartments.presentation.model

import android.widget.TextView
import com.denzcoskun.imageslider.models.SlideModel

data class ApartmentUiModel(
    val apartmentImages: List<SlideModel>,
    val hotelName: String,
    val chips: List<TextView>,
    val price: ApartmentPrice
)

data class ApartmentPrice(
    val price: String,
    val description: String
)