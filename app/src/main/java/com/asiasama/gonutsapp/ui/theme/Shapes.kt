package com.asiasama.gonutsapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val RoundedShape = Shapes(
    large = RoundedCornerShape(
        topEnd = 20.dp,
        topStart = 20.dp,
        bottomEnd = 10.dp,
        bottomStart = 10.dp
    ),
    medium = RoundedCornerShape(20.dp),
    small = RoundedCornerShape(15.dp),
    extraSmall = RoundedCornerShape(10.dp),
    extraLarge = RoundedCornerShape(50.dp)

)