package com.example.hotel.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.code_data.di.ViewModelKey
import com.example.hotel.data.network.HotelApiService
import com.example.hotel.data.repository.HotelRepositoryImpl
import com.example.hotel.domain.repository.HotelRepository
import com.example.hotel.presentation.HotelViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
interface HotelModule {

    @Binds
    fun bindHotelRepository(hotelRepositoryImpl: HotelRepositoryImpl): HotelRepository

    @IntoMap
    @Binds
    @ViewModelKey(HotelViewModel::class)
    fun bindHotelViewModel(viewModel: HotelViewModel): ViewModel

    companion object {
        @Provides
        fun provideContext(application: Application): Context {
            return application.applicationContext
        }

        @Provides
        fun provideHotelApiService(retrofit: Retrofit): HotelApiService {
            return retrofit.create(HotelApiService::class.java)
        }


    }

}