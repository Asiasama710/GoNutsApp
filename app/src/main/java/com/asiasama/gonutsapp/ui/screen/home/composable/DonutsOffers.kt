package com.asiasama.gonutsapp.ui.screen.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.asiasama.gonutsapp.R
import com.asiasama.gonutsapp.ui.screen.home.DonatOfferUiState
import com.asiasama.gonutsapp.ui.theme.Black_87
import com.asiasama.gonutsapp.ui.theme.OnTertiary
import com.asiasama.gonutsapp.ui.theme.Tertiary
import com.asiasama.gonutsapp.ui.theme.Typography


@Composable
fun DonutsOffers(
    offers: List<DonatOfferUiState>,
    onClick: () -> Unit = {}
) {
    Text(
        text = stringResource(R.string.today_offers),
        color = Black_87,
        style = Typography.titleSmall,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
            .padding(horizontal = 16.dp)
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(items = offers) { position, items ->
            val backgroundColor = if (position % 2 == 0) OnTertiary  else Tertiary
            OffersCard(state =  items,backgroundColor, onClick = onClick)
        }
    }
}