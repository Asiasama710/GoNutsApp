package com.asiasama.gonutsapp.ui.screen.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.asiasama.gonutsapp.ui.theme.Black_87
import com.asiasama.gonutsapp.ui.theme.RoundedShape
import com.asiasama.gonutsapp.ui.theme.Typography
import com.asiasama.gonutsapp.ui.theme.White_FF

@Composable
fun ButtonItem(text : String, modifier: Modifier = Modifier, onClick:() -> Unit,textColor:Color = Black_87, backgroundColor: Color = White_FF) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = modifier
            .height(54.dp)
            .fillMaxWidth(),
        shape = RoundedShape.extraLarge
    ){
        Text(
            text = text,
            style = Typography.titleSmall,
            color = textColor
        )
    }
}
