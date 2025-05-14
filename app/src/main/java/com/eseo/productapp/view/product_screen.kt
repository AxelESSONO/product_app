package com.eseo.productapp.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ProductScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            MyTopAppBar()
        }
    ) {  }
}
























