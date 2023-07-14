package com.asiasama.gonutsapp.ui.screen.details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asiasama.gonutsapp.R
import com.asiasama.gonutsapp.ui.screen.composable.ButtonCounter
import com.asiasama.gonutsapp.ui.screen.composable.ButtonIcon
import com.asiasama.gonutsapp.ui.screen.composable.customShadow
import com.asiasama.gonutsapp.ui.theme.Black_87
import com.asiasama.gonutsapp.ui.theme.RoundedShape
import com.asiasama.gonutsapp.ui.theme.Typography
import com.asiasama.gonutsapp.ui.theme.White_FF

@Preview
@Composable
fun CounterSection(
    onClickPlus: () -> Unit = {},
    onClickMinus: () -> Unit = {},
    quantity: String = "1",
) {

    Row(
        modifier = Modifier.padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ButtonCounter(
            text = stringResource(R.string.minus),
            modifier = Modifier
                .size(45.dp)
                .customShadow(shape = RoundedShape.small)
                .background(color = White_FF)
                .clip(RoundedShape.small),
            onClick = onClickMinus
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(45.dp)
                .customShadow(shape = RoundedShape.small)
                .background(color = White_FF)
                .clip(RoundedShape.small),
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = quantity,
                textAlign = TextAlign.Center,
                style = Typography.bodyLarge,
                color = Black_87
            )
        }
        ButtonCounter(
            text = stringResource(R.string.plus), modifier = Modifier
                .size(45.dp)
                .customShadow(shape = RoundedShape.small)
                .background(color = White_FF)
                .clip(RoundedShape.small),
            onClick = onClickPlus
        )
    }
}