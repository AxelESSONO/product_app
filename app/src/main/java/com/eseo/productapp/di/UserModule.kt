package com.eseo.productapp.di

import com.eseo.productapp.model.repository.UserRepository
import com.eseo.productapp.model.service.ProductApi
import com.eseo.productapp.model.service.UserApi
import com.eseo.productapp.viewmodel.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun provideUserApi() : UserApi{
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userApi: UserApi) : UserRepository{
        return UserRepository(userApi)
    }

    @Provides
    @Singleton
    fun provideUserViewModel(userRepository: UserRepository) : UserViewModel{
        return UserViewModel(userRepository)
    }

}






