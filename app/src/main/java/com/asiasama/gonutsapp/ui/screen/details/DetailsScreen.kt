package com.asiasama.gonutsapp.ui.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.asiasama.gonutsapp.R
import com.asiasama.gonutsapp.ui.screen.main.LocalNavigationProvider
import com.asiasama.gonutsapp.ui.screen.composable.ButtonIcon
import com.asiasama.gonutsapp.ui.screen.composable.ButtonItem
import com.asiasama.gonutsapp.ui.screen.composable.Schofield
import com.asiasama.gonutsapp.ui.screen.composable.customShadow
import com.asiasama.gonutsapp.ui.screen.composable.BottomSheet
import com.asiasama.gonutsapp.ui.screen.details.composable.CounterSection
import com.asiasama.gonutsapp.ui.screen.onboarding.navigateToOnBoarding
import com.asiasama.gonutsapp.ui.theme.Black_60
import com.asiasama.gonutsapp.ui.theme.Black_87
import com.asiasama.gonutsapp.ui.theme.Primary
import com.asiasama.gonutsapp.ui.theme.RoundedShape
import com.asiasama.gonutsapp.ui.theme.Tertiary
import com.asiasama.gonutsapp.ui.theme.Typography
import com.asiasama.gonutsapp.ui.theme.White_FF

@Preview(showSystemUi = true)
@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavigationProvider.current
    DetailsContent(
        state = state,
        onClickBack = navController::popBackStack,
        increaseQuantity = viewModel::increaseQuantity,
        decreaseQuantity = viewModel::decreaseQuantity,
        onClickFavorite = navController::navigateToOnBoarding,
    )
}


@Composable
fun DetailsContent(
    state: DetailsUiState,
    onClickBack: () -> Unit,
    increaseQuantity: () -> Unit,
    decreaseQuantity: () -> Unit,
    onClickFavorite: () -> Unit,
) {
    Schofield(content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Tertiary)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .height(340.dp)
                    .fillMaxWidth()
            ) {

                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.donut_offers_1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                ButtonIcon(
                    modifier = Modifier.align(Alignment.TopStart),
                    onClick = onClickBack,
                    iconTint = Primary,
                    painter = painterResource(id = R.drawable.arrow_left)
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .zIndex(6f)
                    .offset(x = (-50).dp, y = (-80).dp)
            )
            {
                ButtonIcon(
                    modifier = Modifier
                        .size(45.dp)
                        .customShadow(shape = RoundedShape.small)
                        .background(shape = RoundedShape.small, color = White_FF)
                        .clip(RoundedShape.small),
                    onClick = onClickFavorite,
                    iconTint = Primary,
                    painter = painterResource(id = R.drawable.baseline_favorite_border_24)
                )
            }

            BottomSheet(modifier = Modifier.align(Alignment.BottomCenter)) {
                Text(
                    text = "Strawberry Wheel",
                    modifier = Modifier.padding(vertical = 35.dp),
                    color = Primary,
                    style = Typography.titleMedium
                )

                Text(
                    text = stringResource(R.string.about_gonut),
                    modifier = Modifier.padding(bottom = 16.dp),
                    style = Typography.bodyLarge,
                    color = Black_87
                )
                Text(
                    text = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                    style = Typography.labelMedium,
                    color = Black_60
                )
                Text(
                    text = stringResource(R.string.quantity),
                    modifier = Modifier.padding(top = 16.dp),
                    style = Typography.bodyLarge,
                    color = Black_87
                )
                CounterSection(
                    onClickPlus = increaseQuantity,
                    onClickMinus = decreaseQuantity,
                    quantity = if (state.dauntOffers.quantity > 16) "0" else state.dauntOffers.quantity.toString()
                )
                Row(
                    modifier = Modifier.align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "£${state.dauntOffers.price}",
                        style = Typography.titleMedium,
                        color = Black_87,
                    )
                    ButtonItem(
                        text = stringResource(R.string.add_to_cart),
                        onClick = {},
                        backgroundColor = Primary,
                        textColor = White_FF,
                        modifier = Modifier.width(200.dp)
                    )

                }
            }
        }
    })

}