package com.example.hotel.presentation.model

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.denzcoskun.imageslider.models.SlideModel
import com.example.hotel.R
import com.example.hotel.domain.entity.HotelInfo
import javax.inject.Inject

class ViewMapper @Inject constructor(
    private val context: Context
) {
    fun mapDomainEntityToPresentationEntity(domainEntity: HotelInfo) = PresentationModel(
        hotelImages = domainEntity.hotelImages.map { SlideModel(it) },
        hotelRating = context.getString(com.example.core_ui.R.string.rating_text, domainEntity.rating, domainEntity.ratingName),
        hotelName = domainEntity.name,
        hotelLocation = domainEntity.address,
        price = HotelPrice(
            price = context.getString(com.example.core_ui.R.string.price_text, domainEntity.minimalPrice),
            description = domainEntity.priceForIt
        ),
        chips = domainEntity.detailInfo.second.map { chipText -> textView(chipText) },
        description = domainEntity.detailInfo.first
    )


    private fun textView(text: String): TextView {
        val textView = TextView(context)
        textView.text = text
        textView.setBackgroundResource(com.example.core_ui.R.drawable.rounded_background)
        textView.setTextColor(context.resources.getColor(R.color.gray, context.theme))

        val typeface = ResourcesCompat.getFont(context, com.example.core_ui.R.font.sf_pro_display_medium)
        textView.typeface = typeface

        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        layoutParams.marginEnd = context.resources.getDimensionPixelSize(com.example.core_ui.R.dimen.margin_6dp)

        textView.layoutParams = layoutParams
        return textView
    }

}