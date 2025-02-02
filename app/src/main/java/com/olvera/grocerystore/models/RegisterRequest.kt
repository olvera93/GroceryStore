package com.olvera.grocerystore.models

data class RegisterRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String
)
