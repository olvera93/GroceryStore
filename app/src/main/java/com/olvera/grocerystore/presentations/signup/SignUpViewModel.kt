package com.olvera.grocerystore.presentations.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olvera.grocerystore.models.EmailConfirmedResponse
import com.olvera.grocerystore.models.RegisterRequest
import com.olvera.grocerystore.repository.AuthUserRepository
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

    private val _signUpResponse = MutableStateFlow<EmailConfirmedResponse>(
        EmailConfirmedResponse("")
    )
    val signUpResponse = _signUpResponse

    fun signUp(request: RegisterRequest) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repository.signUp(request)
            }

            when(response) {
                is NetworkResult.Success -> {
                    response.data?.message.let {
                        _signUpResponse.value = EmailConfirmedResponse("Success")
                    } ?: run {
                        _signUpResponse.value = EmailConfirmedResponse("Something went wrong")
                    }
                }
                is NetworkResult.Error -> {
                    Log.e("SignUpViewModel", "Error: ${response.massage}")
                    _signUpResponse.value = EmailConfirmedResponse("Error: ${response.massage}")
                }

                is NetworkResult.Loading -> {
                    _signUpResponse.value = EmailConfirmedResponse("Loading")
                }
            }
        }
    }


}