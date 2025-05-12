package com.eseo.productapp.model.repository

import com.eseo.productapp.model.data.ProductResponse
import com.eseo.productapp.model.service.ProductApi
import javax.inject.Inject

class ProductRepository @Inject constructor (
    private val productApi: ProductApi
) {

    fun getProductResponseRepo(): ProductResponse {
        return productApi.getProductResponse()
    }

}















