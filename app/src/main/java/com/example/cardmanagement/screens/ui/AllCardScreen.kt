package com.example.cardmanagement.screens.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cardmanagement.screens.composables.CardItem
import com.example.cardmanagement.viewmodel.CardViewModel

@Composable
fun CardListingScreen(padding: PaddingValues,
                      cardViewModel: CardViewModel,
                      navController: NavController) {

    val cardList = cardViewModel.cards

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(cardList.size) { index ->
            CardItem(card = cardList[index],navController)
        }
    }
}
