package com.merttoptas.retrofittutorial.data.di



import com.merttoptas.retrofittutorial.data.remote.api.UserApiService
import com.merttoptas.retrofittutorial.data.repository.UsersRepository
import com.merttoptas.retrofittutorial.data.repository.UsersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


    @Module
    @InstallIn(ViewModelComponent::class)
    class UserModule {
        // Api Service Class
        // Repository and DataSource Impl
        // Database

        @Provides
        fun provideApiService(retrofit: Retrofit) : UserApiService {
            return retrofit.create(UserApiService::class.java)
        }

        @Provides
        fun providePostRepository(userApiService: UserApiService) : UsersRepository{
            return UsersRepositoryImpl(userApiService)
        }
    }
