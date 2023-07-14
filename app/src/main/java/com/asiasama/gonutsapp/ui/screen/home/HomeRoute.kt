package com.asiasama.gonutsapp.ui.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.asiasama.gonutsapp.ui.navigation.BottomBarScreen


private const val ROUTE = "Home"

fun NavController.navigateToHomeScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute() {
    composable(BottomBarScreen.Home.route) { HomeScreen() }
}
