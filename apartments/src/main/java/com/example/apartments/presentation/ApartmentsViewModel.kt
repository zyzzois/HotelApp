package com.example.apartments.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apartments.domain.entity.ApartmentEntity
import com.example.apartments.domain.usecase.GetApartmentsListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApartmentsViewModel @Inject constructor(
    private val getApartmentsList: GetApartmentsListUseCase
): ViewModel() {

    private val _apartments = MutableLiveData<List<ApartmentEntity>>()
    val apartments: LiveData<List<ApartmentEntity>>
        get() = _apartments

    init {
        viewModelScope.launch {
            _apartments.value = getApartmentsList()
        }
    }


}