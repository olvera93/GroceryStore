package com.olvera.grocerystore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.olvera.grocerystore.navigation.NavManager
import com.olvera.grocerystore.presentations.signup.SignUpViewModel
import com.olvera.grocerystore.ui.theme.GroceryStoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val signUpViewModel: SignUpViewModel by viewModels()
        setContent {
            GroceryStoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavManager(
                        modifier = Modifier.padding(innerPadding),
                        signUpViewModel = signUpViewModel
                    )
                }
            }
        }
    }
}
