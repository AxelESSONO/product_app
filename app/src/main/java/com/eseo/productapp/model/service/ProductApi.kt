package com.eseo.productapp.model.service

import com.eseo.productapp.model.data.Product
import com.eseo.productapp.model.user.User
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProductResponse(): List<Product>

    @GET("users")
    suspend fun getUserResponse(): List<User>

}