package com.olvera.grocerystore.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.olvera.grocerystore.R


@Composable
fun GroceryTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholder: String = "",
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String = "",
    isSingleLine: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
) {

    OutlinedTextField(
        modifier = modifier,
        label = { Text(text = label) },
        value = value,
        placeholder = { Text(text = placeholder) },
        onValueChange = onValueChange,
        isError = isError,
        supportingText = {
            if (isError) {
                Text(text = errorMessage)
            }
        },
        singleLine = isSingleLine,
        leadingIcon = leadingIcon,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )
}

@Composable
fun GroceryTextFieldPassword(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholder: String = "",
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String = "",
    isPassword: Boolean = true,
    isSingleLine: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    trailingIcon: @Composable (() -> Unit)? = null,
    passwordVisible: Boolean = false,
    onPasswordVisibilityChange: (Boolean) -> Unit
) {

    OutlinedTextField(
        modifier = modifier,
        label = { Text(text = label) },
        value = value,
        placeholder = { Text(text = placeholder) },
        onValueChange = onValueChange,
        isError = isError,
        supportingText = {
            if (isError) {
                Text(text = errorMessage)
            }
        },
        singleLine = isSingleLine,
        leadingIcon = leadingIcon,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = trailingIcon ?: if (isPassword) {
            {
                IconButton(onClick = { onPasswordVisibilityChange(!passwordVisible) }) {
                    Icon(
                        painter = painterResource(id = if (passwordVisible) R.drawable.visibility_24px else R.drawable.visibility_off_24px),
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        tint = Color.Gray
                    )
                }
            }
        } else null
    )
}

@Preview(showBackground = true)
@Composable
fun GroceryTextFieldPreview() {
    GroceryTextField(
        label = "Nombre",
        value = "",
        onValueChange = {},
        isError = false
    )
}