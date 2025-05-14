package com.eseo.productapp.model.repository

import android.util.Log
import com.eseo.productapp.model.data.Product
import com.eseo.productapp.model.service.ProductApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepository @Inject constructor (
    private val productApi: ProductApi
) {

    fun getProductsFlow(): Flow<List<Product>> = flow {
        emit(productApi.getProductResponse())
    }.catch { e ->
        Log.e("ProductRepository", "Error fetching products", e)
        emit(emptyList())
    }

}















