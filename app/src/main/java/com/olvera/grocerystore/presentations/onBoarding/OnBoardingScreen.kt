package com.olvera.grocerystore.presentations.onBoarding

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.olvera.grocerystore.R
import com.olvera.grocerystore.components.CustomCardOnboarding

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {


    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.grocery))
    val progress by animateLottieCompositionAsState(composition)

    val brush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF9775FA),
            Color(0xFF9775FA)
        )
    )

    Box(
        modifier = modifier.background(brush = brush)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(35.dp))


            LottieAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(468.dp),
                composition = composition,
                iterations = LottieConstants.IterateForever,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(15.dp)
            ) {

                CustomCardOnboarding()
            }
        }
    }
}