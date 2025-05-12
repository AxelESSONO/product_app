package com.eseo.productapp.model.service

import com.eseo.productapp.model.data.ProductResponse
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    fun getProductResponse(): ProductResponse

}