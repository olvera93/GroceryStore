package com.olvera.grocerystore.state

data class FormValidationState(
    val firstNameError: String? = null,
    val lastNameError: String? = null,
    val emailError: String? = null,
    val usernameError: String? = null,
    val passwordError: String? = null,
    val passwordConfirmationError: String? = null
) {
    val isValid: Boolean
        get() = firstNameError == null &&
                lastNameError == null &&
                emailError == null &&
                usernameError == null &&
                passwordError == null &&
                passwordConfirmationError == null
}

