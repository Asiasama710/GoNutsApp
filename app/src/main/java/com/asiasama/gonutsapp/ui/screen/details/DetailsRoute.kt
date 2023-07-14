package com.asiasama.gonutsapp.ui.screen.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "Details"

fun NavController.navigateToDonutDetails() {
    navigate(ROUTE)
}

fun NavGraphBuilder.detailsRoute() {
    composable(route = ROUTE) {
        DetailsScreen()
    }
}