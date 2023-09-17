package com.example.apartments.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.apartments.data.network.ApartmentsApiService
import com.example.apartments.data.repository.ApartmentsRepositoryImpl
import com.example.apartments.domain.repository.ApartmentsRepository
import com.example.apartments.presentation.ApartmentsViewModel
import com.example.code_data.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
interface ApartmentsModule {

    @Binds
    fun bindApartmentsRepository(apartmentsRepositoryImpl: ApartmentsRepositoryImpl): ApartmentsRepository

    @IntoMap
    @Binds
    @ViewModelKey(ApartmentsViewModel::class)
    fun bindApartmentsViewModel(viewModel: ApartmentsViewModel): ViewModel

    companion object {
        @Provides
        fun provideContext(application: Application): Context {
            return application.applicationContext
        }

        @Provides
        fun provideApiService(retrofit: Retrofit): ApartmentsApiService {
            return retrofit.create(ApartmentsApiService::class.java)
        }


    }

}