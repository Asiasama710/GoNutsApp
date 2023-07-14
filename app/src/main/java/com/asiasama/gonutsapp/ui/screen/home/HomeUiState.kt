package com.asiasama.gonutsapp.ui.screen.home


data class HomeUiState(
    val dauntOffers: List<DonatOfferUiState> = emptyList(),
    val daunt: List<DunantUiState> = emptyList(),
)
data class DonatOfferUiState(
    val name:String = "",
    val description:String="",
    val image:Int=0,
    val price:String= "16",
    val discount:String="",
    var quantity:Int= 1,
)
data class DunantUiState(
    val name:String="",
    val image:Int=0,
    val price:String="",
)