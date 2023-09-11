package com.example.apartments.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.apartments.domain.entity.ApartmentInfo

class ApartmentsListAdapter(

): ListAdapter<ApartmentInfo, ApartmentsHolder>(ApartmentItemDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartmentsHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ApartmentsHolder, position: Int) {
        TODO("Not yet implemented")
    }

}
