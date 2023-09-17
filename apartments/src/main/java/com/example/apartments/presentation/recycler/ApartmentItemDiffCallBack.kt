package com.example.apartments.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.apartments.domain.entity.ApartmentEntity
import com.example.apartments.presentation.model.ApartmentUiModel

object ApartmentItemDiffCallBack: DiffUtil.ItemCallback<ApartmentUiModel>() {
    override fun areItemsTheSame(oldItem: ApartmentUiModel, newItem: ApartmentUiModel): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: ApartmentUiModel, newItem: ApartmentUiModel): Boolean {
        return oldItem == newItem
    }
}
