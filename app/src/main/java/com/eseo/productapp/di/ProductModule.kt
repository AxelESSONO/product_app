package com.eseo.productapp.di

import com.eseo.productapp.model.repository.ProductRepository
import com.eseo.productapp.model.service.ProductApi
import com.eseo.productapp.viewmodel.ProductViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Provides
    @Singleton
    fun provideProductApi() : ProductApi{
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        productApi: ProductApi) : ProductRepository{
        return ProductRepository(productApi)
    }

    @Provides
    @Singleton
    fun  provideProductViewModel(
        productRepository: ProductRepository) : ProductViewModel{
        return ProductViewModel(productRepository)
    }

}
















