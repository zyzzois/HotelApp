package com.example.apartments.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.apartments.domain.entity.ApartmentInfo

object ApartmentItemDiffCallBack: DiffUtil.ItemCallback<ApartmentInfo>() {
    override fun areItemsTheSame(oldItem: ApartmentInfo, newItem: ApartmentInfo): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: ApartmentInfo, newItem: ApartmentInfo): Boolean {
        return oldItem == newItem
    }
}
