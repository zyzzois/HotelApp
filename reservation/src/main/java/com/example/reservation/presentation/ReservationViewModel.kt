package com.example.reservation.presentation

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reservation.domain.entity.ReservationInfo
import com.example.reservation.domain.usecase.GetReservationInfoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReservationViewModel @Inject constructor(
    private val getReservationInfo: GetReservationInfoUseCase
): ViewModel() {

    var touristsCounter = 0

    private val _errorInputMail = MutableLiveData<Boolean>()
    val errorInputMail: LiveData<Boolean>
        get() = _errorInputMail

    private val _errorInputNumber = MutableLiveData<Boolean>()
    val errorInputNumber: LiveData<Boolean>
        get() = _errorInputNumber

    private val _errorInputDetails = MutableLiveData<Boolean>()
    val errorInputDetails: LiveData<Boolean>
        get() = _errorInputDetails

    private val _hotelInfo = MutableLiveData<ReservationInfo>()
    val currentWeather: LiveData<ReservationInfo>
        get() = _hotelInfo

    fun inputContactsIsValid(mail: String, number: String): Boolean {
        if (mail.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            _errorInputMail.value = true
            return false
        }
        if (number.isBlank()) {
            _errorInputNumber.value = true
            return false
        }
        return true
    }


    fun resetErrorInputMail() {
        _errorInputMail.value = false
    }

    fun resetErrorInputNumber() {
        _errorInputNumber.value = false
    }


    init {
        viewModelScope.launch {
            _hotelInfo.value = getReservationInfo()
        }
    }

}