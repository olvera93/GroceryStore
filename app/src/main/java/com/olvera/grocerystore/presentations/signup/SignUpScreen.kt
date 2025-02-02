package com.olvera.grocerystore.presentations.signup

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.olvera.grocerystore.models.RegisterRequest

@Composable
fun SignUpScreen(viewModel: SignUpViewModel) {

    val signUp by viewModel.signUpResponse.collectAsState()

    val request = RegisterRequest(
        firstName = "John",
        lastName = "Doe",
        email = "john.mclean@examplepetstore.com",
        password = "password",
        passwordConfirmation = "password"
    )

    LaunchedEffect(key1 = signUp) {
        if (signUp.message == "Success") {
            // Navigate to next screen
            Log.d("SignUpScreen", "Success: ${request}")
        }
    }

    Column(modifier = Modifier) {



    }

}