package com.olvera.grocerystore.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.olvera.grocerystore.presentations.onBoarding.OnBoardingScreen
import com.olvera.grocerystore.presentations.signup.SignUpScreen
import com.olvera.grocerystore.presentations.signup.SignUpViewModel

@Composable
fun NavManager(
    modifier: Modifier = Modifier,
    signUpViewModel: SignUpViewModel
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "onBoarding") {
        composable("onBoarding") {
            OnBoardingScreen(
                modifier = Modifier.padding(),
                navController = navController
            )
        }

        composable("signUp") {
            SignUpScreen(modifier, signUpViewModel)
        }

    }

}