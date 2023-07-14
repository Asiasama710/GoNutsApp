package com.asiasama.gonutsapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.asiasama.gonutsapp.R
import com.asiasama.gonutsapp.ui.screen.main.LocalNavigationProvider
import com.asiasama.gonutsapp.ui.navigation.BottomBar
import com.asiasama.gonutsapp.ui.screen.composable.ButtonIcon
import com.asiasama.gonutsapp.ui.screen.composable.Schofield
import com.asiasama.gonutsapp.ui.screen.details.navigateToDonutDetails
import com.asiasama.gonutsapp.ui.screen.home.composable.Donuts
import com.asiasama.gonutsapp.ui.screen.home.composable.DonutsOffers
import com.asiasama.gonutsapp.ui.screen.onboarding.navigateToOnBoarding
import com.asiasama.gonutsapp.ui.theme.Black_60
import com.asiasama.gonutsapp.ui.theme.Primary
import com.asiasama.gonutsapp.ui.theme.RoundedShape
import com.asiasama.gonutsapp.ui.theme.Tertiary
import com.asiasama.gonutsapp.ui.theme.Typography

@Preview(showSystemUi = true)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavigationProvider.current

    HomeContent(
        state = state,
        onClickSearch = navController::navigateToOnBoarding,
        onClickDonutsOffers = navController::navigateToDonutDetails
    )
}


@Composable
fun HomeContent(
    state: HomeUiState,
    onClickSearch: () -> Unit = {},
    onClickDonutsOffers: () -> Unit = {},
) {
    val navController = LocalNavigationProvider.current

    Schofield(
        content = { modifier ->

            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 24.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.let_s_gonuts),
                            color = Primary,
                            style = Typography.titleMedium,
                            modifier = Modifier.wrapContentWidth()
                        )
                        Text(
                            text = stringResource(R.string.order_your_favourite_donuts_from_here),
                            color = Black_60,
                            style = Typography.bodyMedium,
                            modifier = Modifier
                        )
                    }
                    ButtonIcon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        onClick = onClickSearch,
                        iconTint = Primary,
                        modifier = Modifier
                            .size(45.dp)
                            .background(shape = RoundedShape.small, color = Tertiary)
                            .clip(RoundedShape.small)
                    )

                }
                DonutsOffers(offers = state.dauntOffers, onClick = onClickDonutsOffers)
                Donuts(donuts = state.daunt)
            }

        },
        bottomBar = {
            BottomBar(navController = navController)
        })

}
