package com.eseo.productapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eseo.productapp.ui.theme.Pink80
import com.eseo.productapp.ui.theme.ProductAppTheme
import com.eseo.productapp.ui.theme.PurpleGrey40

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductAppTheme {
                LoginScreen(){
                    val intent = Intent(this, ProductActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val onEmailChange = { text: String ->
        email = text
    }
    val onPasswordChange = { text: String ->
        password = text
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            10.dp,
            alignment = Alignment.CenterVertically
        ),
        modifier = modifier
            .fillMaxSize()
            .background(PurpleGrey40)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.8f),
            value = email,
            onValueChange = onEmailChange,
            label = { Text("Email") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Pink80,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.8f),
            value = password,
            onValueChange = onPasswordChange,
            label = { Text("Password") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Pink80,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Button(
            onClick = {onClick()},
            modifier = Modifier.fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Pink80,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Login"
            )
        }
    }
}
