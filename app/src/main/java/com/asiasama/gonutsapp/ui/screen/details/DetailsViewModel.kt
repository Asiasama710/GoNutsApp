package com.asiasama.gonutsapp.ui.screen.details

import androidx.lifecycle.ViewModel
import com.asiasama.gonutsapp.ui.screen.home.DonatOfferUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()


    fun increaseQuantity() {
        if (state.value.dauntOffers.quantity < 16) {
            _state.update {
                it.copy(
                    dauntOffers = DonatOfferUiState(
                        quantity = (it.dauntOffers.quantity + 1),
                        price = (it.dauntOffers.price.toInt() * 2).toString()
                    )
                )
            }
        }

    }

    fun decreaseQuantity() {
        if (state.value.dauntOffers.quantity > 1) {
            _state.update {
                it.copy(
                    dauntOffers = DonatOfferUiState(
                        quantity = (it.dauntOffers.quantity - 1),
                        price = (it.dauntOffers.price.toInt() / it.dauntOffers.quantity).toString()
                    )
                )
            }
        }
    }

}