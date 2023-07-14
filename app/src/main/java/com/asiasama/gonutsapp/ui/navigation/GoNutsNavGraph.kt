package com.asiasama.gonutsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.asiasama.gonutsapp.ui.screen.main.LocalNavigationProvider
import com.asiasama.gonutsapp.ui.screen.details.detailsRoute
import com.asiasama.gonutsapp.ui.screen.home.homeRoute
import com.asiasama.gonutsapp.ui.screen.onboarding.onBoardingRoute


@Composable
fun GoNutsNavGraph() {
    val navController = LocalNavigationProvider.current

    NavHost(navController = navController, startDestination = Screen.OnBoarding.rout) {
        homeRoute()
        composable(route = BottomBarScreen.Favorite.route) { }
        composable(route = BottomBarScreen.Notification.route) { }
        composable(route = BottomBarScreen.Cart.route) { }
        composable(route = BottomBarScreen.Profile.route) { }
        onBoardingRoute()
        detailsRoute()
    }

}

sealed class Screen(val rout: String) {
    object OnBoarding : Screen("OnBoarding")
}
