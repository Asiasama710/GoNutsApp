package com.asiasama.gonutsapp.ui.screen.onboarding

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.asiasama.gonutsapp.R
import com.asiasama.gonutsapp.ui.screen.main.LocalNavigationProvider
import com.asiasama.gonutsapp.ui.screen.composable.ButtonItem
import com.asiasama.gonutsapp.ui.screen.home.navigateToHomeScreen
import com.asiasama.gonutsapp.ui.theme.Primary
import com.asiasama.gonutsapp.ui.theme.Tertiary
import com.asiasama.gonutsapp.ui.theme.Typography
import kotlin.math.roundToInt

@Composable
fun OnBoardingScreen() {
    val navController = LocalNavigationProvider.current

    OnBoardingContent(
        onClickGetStart = navController::navigateToHomeScreen
    )
}

@Preview(showSystemUi = true)
@Composable
fun OnBoardingContent(
    onClickGetStart: () -> Unit = {},
) {

    val infiniteTransition = rememberInfiniteTransition()

    val offset by infiniteTransition.animateValue(
        initialValue = Offset.Zero,
        targetValue = Offset(-50f, -50f),
        typeConverter = Offset.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 10000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(modifier = Modifier.fillMaxSize().background(color = Tertiary)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_image_background),
                contentDescription = null,
                modifier = Modifier
                    .offset(y = (40).dp,x= (80).dp)
                    .scale(1.8f)
                    .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) },
           )
        }

        Column(
            modifier = Modifier
                .padding(40.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Text(
                text = stringResource(R.string.gonuts_with_donuts),
                color = Primary,
                style = Typography.titleLarge,
                modifier = Modifier
                    .width(200.dp),
                maxLines = 3,

                )
            Text(
                text = stringResource(R.string.description),
                color = Primary,
                style = Typography.bodyLarge,
                modifier = Modifier.padding(top = 20.dp),
                maxLines = 4,

                )
            ButtonItem(
                text = stringResource(R.string.get_started),
                onClick = onClickGetStart,
                modifier = Modifier.padding(top = 40.dp)
            )
        }
    }


}