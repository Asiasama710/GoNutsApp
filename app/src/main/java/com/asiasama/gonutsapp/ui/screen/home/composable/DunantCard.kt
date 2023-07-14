package com.asiasama.gonutsapp.ui.screen.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.asiasama.gonutsapp.ui.screen.composable.customShadow
import com.asiasama.gonutsapp.ui.screen.home.DunantUiState
import com.asiasama.gonutsapp.ui.theme.Black_87
import com.asiasama.gonutsapp.ui.theme.Primary
import com.asiasama.gonutsapp.ui.theme.RoundedShape
import com.asiasama.gonutsapp.ui.theme.Typography
import com.asiasama.gonutsapp.ui.theme.White_FF

@Preview(showBackground = true)
@Composable
fun DunantCard(
    state: DunantUiState = DunantUiState(),
) {
    Box{

        Column(
            modifier = Modifier
                .zIndex(1f)
                .align(Alignment.Center)
                .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        )  {
            Image(
                painter = painterResource(id = state.image),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = state.name,
                color = Black_87,
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = state.price,
                color = Primary,
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(160.dp)
                .padding(top = 30.dp)
                .customShadow(RoundedShape.large)
                .background(
                    color = White_FF,
                    shape = RoundedShape.large
                )
        )

    }
}