package com.asiasama.gonutsapp.ui.screen.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.asiasama.gonutsapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) :ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getDauntOffers()
        getDonat()
    }
    private fun getDauntOffers(){
        _state.update {
            it.copy(
                dauntOffers = listOf(
                    DonatOfferUiState(
                        name = "Strawberry Wheel",
                        description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                        image = R.drawable.donut_offers_1,
                        price = "$10",
                        discount = "$20"
                    ),
                    DonatOfferUiState(
                        name = "Chocolate Glaze",
                        description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                        image = R.drawable.donut_offers_2,
                        price = "$10",
                        discount = "$20"
                    ),
                )
            )
        }
    }
    private fun getDonat(){
        _state.update {
            it.copy(
                daunt = listOf(
                    DunantUiState(
                        name = "Chocolate Cherry",
                        image = R.drawable.donut_1,
                        price = "$10",
                    ),
                    DunantUiState(
                        name = "Strawberry Rain",
                        image = R.drawable.donut_2,
                        price = "$10",
                    ),
                    DunantUiState(
                        name = "Strawberry Coco",
                        image = R.drawable.donut_3,
                        price = "$10",
                    ),

                )
            )
        }
    }

}