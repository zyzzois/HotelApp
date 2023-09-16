package com.example.hotel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotel.domain.entity.HotelInfo
import com.example.hotel.domain.usecase.GetHotelInfoUseCase
import com.example.hotel.presentation.model.PresentationModel
import com.example.hotel.presentation.model.ViewMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class HotelViewModel @Inject constructor(
   private val getHotelInfoUseCase: GetHotelInfoUseCase
//    private val mapper: ViewMapper
): ViewModel() {

    private val _hotelInfo = MutableLiveData<HotelInfo>()
    val currentWeather: LiveData<HotelInfo>
        get() = _hotelInfo

    init {
        viewModelScope.launch {
            //_hotelInfo.value = mapper.mapDomainEntityToPresentationEntity(getHotelInfoUseCase())
            _hotelInfo.value = getHotelInfoUseCase()
        }
    }

}