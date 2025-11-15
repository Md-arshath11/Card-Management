package com.example.cardmanagement.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cardmanagement.screens.ui.AddCardScreen
import com.example.cardmanagement.screens.ui.CardDetailsScreen
import com.example.cardmanagement.screens.ui.CardListingScreen
import com.example.cardmanagement.screens.ui.DashboardScreen
import com.example.cardmanagement.viewmodel.CardViewModel

@Composable
fun NavGraph(navController: NavHostController,
             padding: PaddingValues,
             cardViewModel: CardViewModel
) {
    NavHost(navController, startDestination = "dashboard") {
        composable("dashboard") {
            DashboardScreen(padding,cardViewModel,navController)
        }
        composable("cards") {
            CardListingScreen(padding,cardViewModel,navController)
        }

        composable("add_cards") {
            AddCardScreen(padding,navController,cardViewModel)
        }
        composable("card_details") {
            CardDetailsScreen(navController)
        }

    }
}