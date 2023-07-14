package com.asiasama.gonutsapp.ui.navigation

import com.asiasama.gonutsapp.R


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val selectedIcon: Int,
) {

    object Home : BottomBarScreen(
        route = "Home",
        title = "Home",
        icon = R.drawable.home,
        selectedIcon = R.drawable.home_selected
    )

    object Favorite : BottomBarScreen(
        route = "Favorite",
        title = "Favorite",
        icon = R.drawable.heart,
        selectedIcon = R.drawable.heart_selected
    )

    object Notification : BottomBarScreen(
        route = "Notification",
        title = "Notification",
        icon = R.drawable.notification,
        selectedIcon = R.drawable.notification_selected
    )

    object Cart : BottomBarScreen(
        route = "Cart",
        title = "Cart",
        icon = R.drawable.buy,
        selectedIcon = R.drawable.buy_selected
    )

    object Profile : BottomBarScreen(
        route = "Profile",
        title = "Profile",
        icon = R.drawable.profile,
        selectedIcon = R.drawable.profile_selected
    )

}