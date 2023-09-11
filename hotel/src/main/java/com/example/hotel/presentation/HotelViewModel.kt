package com.example.hotel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotel.domain.entity.HotelInfo
import com.example.hotel.domain.usecase.GetHotelInfoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HotelViewModel @Inject constructor(
    private val getHotelInfoUseCase: GetHotelInfoUseCase
): ViewModel() {

    private val _hotelInfo = MutableLiveData<HotelInfo>()
    val currentWeather: LiveData<HotelInfo>
        get() = _hotelInfo

    init {
        viewModelScope.launch {
            _hotelInfo.value = getHotelInfoUseCase()
        }
    }

}