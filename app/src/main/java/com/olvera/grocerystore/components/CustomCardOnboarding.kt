package com.olvera.grocerystore.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.olvera.grocerystore.R

@Composable
fun CustomCardOnboarding(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Card {

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Look for what you need today",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 23.sp,
                    lineHeight = 27.sp,
                    fontFamily = FontFamily(Font(R.font.inter_semibold)),
                    fontWeight = FontWeight(400)
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                text = "Create an account to get started with our app and enjoy a seamless shopping experience.",
                color = Color(0XFF8F959E),
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.fira_sans_light)),
                    fontWeight = FontWeight(400)
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.weight(1F),
                onClick = {
                    navController.navigate("signUp")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {

                Text(
                    text = "Get Started",
                    color = Color(0xFF8F959E)
                )
            }
        }
    }
}

@Preview
@Composable
fun CustomCardOnboardingPreview() {
    //CustomCardOnboarding()
}