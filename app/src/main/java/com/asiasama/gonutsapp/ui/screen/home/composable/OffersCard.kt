package com.asiasama.gonutsapp.ui.screen.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asiasama.gonutsapp.R
import com.asiasama.gonutsapp.ui.screen.composable.ButtonIcon
import com.asiasama.gonutsapp.ui.screen.composable.customShadow
import com.asiasama.gonutsapp.ui.screen.home.DonatOfferUiState
import com.asiasama.gonutsapp.ui.theme.Black_60
import com.asiasama.gonutsapp.ui.theme.Black_87
import com.asiasama.gonutsapp.ui.theme.OnTertiary
import com.asiasama.gonutsapp.ui.theme.Primary
import com.asiasama.gonutsapp.ui.theme.RoundedShape
import com.asiasama.gonutsapp.ui.theme.Typography
import com.asiasama.gonutsapp.ui.theme.White_FF


@Preview
@Composable
fun OffersCard(
    state: DonatOfferUiState = DonatOfferUiState(),
    backgroundColor: Color = OnTertiary,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(280.dp)
    ) {
        Column(
            modifier = Modifier
                .customShadow(RoundedShape.medium)
                .clickable(onClick = onClick)
                .background(color = backgroundColor, shape = RoundedShape.medium)
                .width(160.dp)
                .wrapContentHeight()
                .padding(15.dp)
            ,
        ) {
            ButtonIcon(
                painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                onClick = {},
                iconTint = Primary,
                modifier = Modifier
                    .size(35.dp)
                    .background(shape = RoundedShape.medium, color = White_FF)
                    .clip(RoundedShape.medium)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = state.name,
                color = Black_87,
                style = Typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = state.description,
                color = Black_60,
                style = Typography.labelSmall,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = state.discount,
                    color = Black_60,
                    style = Typography.bodyMedium,
                    modifier = Modifier.padding(end = 10.dp),
                    textDecoration = TextDecoration.LineThrough
                )
                Text(
                    text = state.price,
                    color = Black_87,
                    style = Typography.titleSmall,
                    modifier = Modifier
                )
            }
        }
        Image(
            painter = painterResource(id = state.image),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(start = 60.dp)

        )
    }

}
