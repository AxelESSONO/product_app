package com.eseo.productapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.eseo.productapp.model.data.Product
import com.eseo.productapp.ui.theme.Pink40
import com.eseo.productapp.ui.theme.PurpleGrey40
import com.eseo.productapp.ui.theme.PurpleGrey80
import com.eseo.productapp.viewmodel.ProductViewModel

@Preview
@Composable
fun ProductScreen(
    modifier: Modifier = Modifier,
    productViewModel: ProductViewModel = hiltViewModel()
) {

    val products = productViewModel.products.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = PurpleGrey80,
        topBar = {
            MyTopAppBar()
        }
    ) { innerPadding ->
        if (products.value.isEmpty()){
            ProductRow()
        }else{
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(products.value){ product ->
                    ProductCard(product)
                }
            }
        }
    }
}
























