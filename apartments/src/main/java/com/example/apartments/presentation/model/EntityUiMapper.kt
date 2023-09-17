package com.example.apartments.presentation.model

import android.content.Context
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.denzcoskun.imageslider.models.SlideModel
import com.example.apartments.R
import com.example.apartments.domain.entity.ApartmentEntity
import javax.inject.Inject

class EntityUiMapper @Inject constructor(
    private val context: Context
) {

    fun mapEntityListToUiModelList(list: List<ApartmentEntity>): List<ApartmentUiModel> {
        return list.map {
            mapEntityToUiModel(it)
        }
    }

    private fun mapEntityToUiModel(entity: ApartmentEntity) = ApartmentUiModel(
        apartmentImages = entity.imageUrls.map { SlideModel(it) },
        hotelName = entity.name,
        chips = entity.peculiarities.map { chipText -> textView(chipText) },
        price = ApartmentPrice(entity.price.toString(), entity.priceDescription)
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