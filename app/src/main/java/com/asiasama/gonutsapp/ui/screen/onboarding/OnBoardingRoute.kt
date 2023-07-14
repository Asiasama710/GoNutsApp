package com.asiasama.gonutsapp.ui.screen.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "OnBoarding"

fun NavController.navigateToOnBoarding() {
    navigate(ROUTE)
}

fun NavGraphBuilder.onBoardingRoute() {
    composable(route = ROUTE) {
        OnBoardingScreen()
    }
}