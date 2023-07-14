package com.asiasama.gonutsapp.ui.screen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun Schofield(
    content: @Composable (Modifier) -> Unit,
    bottomBar: (@Composable () -> Unit)? = null,
) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        content(Modifier.weight(1f))

        Box(modifier = Modifier.fillMaxWidth()) {
            bottomBar?.invoke()
        }
    }

}