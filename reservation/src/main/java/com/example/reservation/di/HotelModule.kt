package com.example.reservation.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.code_data.di.ViewModelKey
import com.example.reservation.data.network.ReservationApiService
import com.example.reservation.data.repository.ReservationRepositoryImpl
import com.example.reservation.domain.repository.ReservationRepository
import com.example.reservation.presentation.ReservationViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
interface ReservationModule {

    @Binds
    fun bindReservationRepository(hotelRepositoryImpl: ReservationRepositoryImpl): ReservationRepository

    @IntoMap
    @Binds
    @ViewModelKey(ReservationViewModel::class)
    fun bindReservationViewModel(viewModel: ReservationViewModel): ViewModel

    companion object {
        @Provides
        fun provideContext(application: Application): Context {
            return application.applicationContext
        }

        @Provides
        fun provideReservationApiService(retrofit: Retrofit): ReservationApiService {
            return retrofit.create(ReservationApiService::class.java)
        }


    }

}