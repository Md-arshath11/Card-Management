package com.example.cardmanagement.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Service(
    val label: String,
    @DrawableRes val icon: Int,
    val backgroundColor: Color,
    val iconColor: Color
)