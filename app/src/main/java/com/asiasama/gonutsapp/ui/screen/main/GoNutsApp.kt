package com.asiasama.gonutsapp.ui.screen.main

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.asiasama.gonutsapp.ui.navigation.GoNutsNavGraph
import com.asiasama.gonutsapp.ui.theme.GoNutsAppTheme


val LocalNavigationProvider = staticCompositionLocalOf<NavHostController> {
    error("No navigation host controller provided.")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GoNutsAppApp() {
    CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {
        GoNutsAppTheme {
            GoNutsNavGraph()
        }

    }
}