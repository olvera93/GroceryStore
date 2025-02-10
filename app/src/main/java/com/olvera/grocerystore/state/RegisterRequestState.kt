package com.olvera.grocerystore.state

data class RegisterRequestState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val username: String = "",
    val password: String = "",
    val passwordConfirmation: String = ""
)
