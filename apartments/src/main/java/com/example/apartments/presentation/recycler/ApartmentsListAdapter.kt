package com.example.apartments.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.example.apartments.databinding.ListItemBinding
import com.example.apartments.domain.entity.ApartmentEntity
import com.example.apartments.presentation.model.ApartmentUiModel

class ApartmentsListAdapter: ListAdapter<ApartmentUiModel, ApartmentsHolder>(ApartmentItemDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartmentsHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ApartmentsHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ApartmentsHolder, position: Int) {
        val apartmentItem = getItem(position)
        val binding = viewHolder.binding
        val context = viewHolder.itemView.context

        binding.tvApartmentName.text = apartmentItem.hotelName
        binding.imageSlider.setImageList(apartmentItem.apartmentImages, ScaleTypes.FIT)

        apartmentItem.chips.forEach {
            binding.scroller.addView(it)
        }

        binding.tvApartmentPrice.text = context.getString(
            com.example.core_ui.R.string.price_text,
            apartmentItem.price.price
        )
        binding.tvApartmentPriceDescription.text = apartmentItem.price.description

    }

}
