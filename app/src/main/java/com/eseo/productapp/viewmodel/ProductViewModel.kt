package com.eseo.productapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eseo.productapp.model.data.ProductResponseItem
import com.eseo.productapp.model.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private var _productShareFlow = MutableSharedFlow<List<ProductResponseItem>>()
    val productShareFlow : SharedFlow<List<ProductResponseItem>> = _productShareFlow

    fun getAllProducts() = viewModelScope.launch(
        Dispatchers.IO
    ) {
        val products : List<ProductResponseItem> = productRepository
            .getProductResponseRepo()
        _productShareFlow.emit(products)
    }
}