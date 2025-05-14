package com.eseo.productapp.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.eseo.productapp.ui.theme.Purple40

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyTopAppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Purple40,
            titleContentColor = Color.White
        ),
        title = {
            Text(text = "Product App")
        }
    )
}

