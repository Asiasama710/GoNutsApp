package com.asiasama.gonutsapp.ui.screen.composable

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.asiasama.gonutsapp.ui.theme.Black_30


@Stable
fun Modifier.customShadow(shape: Shape) = then(
    this.shadow(
        elevation = 10.dp,
        shape = shape,
        ambientColor = Black_30,
        spotColor = Black_30
    )
)