package com.olvera.grocerystore.presentations.signup

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olvera.grocerystore.models.EmailConfirmedResponse
import com.olvera.grocerystore.models.RegisterRequest
import com.olvera.grocerystore.repository.AuthUserRepository
import com.olvera.grocerystore.state.FormValidationState
import com.olvera.grocerystore.state.RegisterRequestState
import com.olvera.grocerystore.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthUserRepository
) : ViewModel() {

    private val _signUpResponse = MutableStateFlow(
        EmailConfirmedResponse("")
    )
    val signUpResponse = _signUpResponse

    var signUpState by mutableStateOf(RegisterRequestState())
        private set

    private val _formValidationState = mutableStateOf(FormValidationState())
    val formValidationState: State<FormValidationState> = _formValidationState

    fun submit() {
        if (formValidationState.value.isValid) {
            signUp()
        } else {
            Log.e("SignUpViewModel", "Form is not valid")
        }
    }

    private fun signUp() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val request = RegisterRequest(
                        firstName = signUpState.firstName,
                        lastName = signUpState.lastName,
                        email = signUpState.email,
                        username = signUpState.username,
                        password = signUpState.password,
                        passwordConfirmation = signUpState.passwordConfirmation
                    )

                    when (val response = repository.signUp(request)) {
                        is NetworkResult.Success -> {
                            _signUpResponse.value = EmailConfirmedResponse("Success")
                        }

                        is NetworkResult.Error -> {
                            Log.e("SignUpViewModel", "Error: ${response.massage}")
                            _signUpResponse.value =
                                EmailConfirmedResponse("Error: ${response.massage}")
                        }

                        is NetworkResult.Loading -> {
                            _signUpResponse.value = EmailConfirmedResponse("Loading")
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("SignUpViewModel", "Exception: ${e.message}", e)
                _signUpResponse.value = EmailConfirmedResponse("Exception: ${e.message}")
            }
        }
    }

    fun updateSignUpState(update: RegisterRequestState.() -> RegisterRequestState) {
        signUpState = signUpState.update()
        validateForm()
    }

    fun validateForm() {
        val errors = FormValidationState(
            firstNameError = if (signUpState.firstName.isEmpty()) "First name is required" else null,
            lastNameError = if (signUpState.lastName.isEmpty()) "Last name is required" else null,
            emailError = if (signUpState.email.isEmpty()) "Email is required" else null,
            usernameError = if (signUpState.username.isEmpty()) "Username is required" else null,
            passwordError = if (signUpState.password.isEmpty()) "Password is required" else null,
            passwordConfirmationError = if (signUpState.passwordConfirmation.isEmpty()) "Password confirmation is required" else null
        )

        _formValidationState.value = errors
    }
}