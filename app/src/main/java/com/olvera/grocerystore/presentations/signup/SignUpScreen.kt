package com.olvera.grocerystore.presentations.signup

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.olvera.grocerystore.components.GroceryTextField

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel
) {

    val signUp by viewModel.signUpResponse.collectAsState()
    val signUpState = viewModel.signUpState

    val focusManager = LocalFocusManager.current


    LaunchedEffect(key1 = signUp) {
        if (signUp.message == "Success") {
            Log.d("SignUpScreen", "Registro exitoso: $signUpState")
            //onSuccess()
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        GroceryTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "First Name",
            value = signUpState.firstName,
            onValueChange = { viewModel.updateSignUpState { copy( firstName = it) } },
            placeholder = "Enter your first name",
            isSingleLine = true,
            isError = false,
            errorMessage = "",
            isPassword = false,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "First Name")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        GroceryTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Last Name",
            value = signUpState.lastName,
            onValueChange = { viewModel.updateSignUpState { copy( lastName = it) } },
            placeholder = "Enter your last name",
            isSingleLine = true,
            isError = false,
            errorMessage = "",
            isPassword = false,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Last Name")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        GroceryTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Email",
            value = signUpState.email,
            onValueChange = { viewModel.updateSignUpState { copy( email = it) } },
            placeholder = "Enter your email",
            isSingleLine = true,
            isError = false,
            errorMessage = "",
            isPassword = false,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        GroceryTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Username",
            value = signUpState.username,
            onValueChange = { viewModel.updateSignUpState { copy( username = it) } },
            placeholder = "Enter your username",
            isSingleLine = true,
            isError = false,
            errorMessage = "",
            isPassword = false,
            leadingIcon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Username")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        GroceryTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Password",
            value = signUpState.password,
            onValueChange = { viewModel.updateSignUpState { copy( password = it) } },
            placeholder = "Enter your password",
            isSingleLine = true,
            isError = false,
            errorMessage = "",
            isPassword = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        GroceryTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Confirm Password",
            value = signUpState.passwordConfirmation,
            onValueChange = { viewModel.updateSignUpState { copy( passwordConfirmation = it) } },
            placeholder = "Confirm your password",
            isSingleLine = true,
            isError = false,
            errorMessage = "",
            isPassword = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = { viewModel.signUp() }
        ) {
            Text(text = "Sign Up")
        }

        Text(text = "Estado: ${signUp.message}")

    }
}