package com.eseo.productapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eseo.productapp.model.data.Product
import com.eseo.productapp.model.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        getAllProducts()
    }

    private fun getAllProducts() = viewModelScope.launch(Dispatchers.IO) {
        productRepository.getProductsFlow().collectLatest {
            _products.value = it
        }
    }

}