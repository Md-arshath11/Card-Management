package com.example.cardmanagement.model

import androidx.compose.ui.graphics.Color

data class Card(
    val bankName: String,
    val cardNumber: String,
    val cardType: String,
    val expiryDate: String,
    val cardColor: Color,
    val cardName: String,
)