package com.example.cardmanagement.screens.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cardmanagement.model.FrequentlyUsedItem
import com.example.cardmanagement.screens.composables.CardItem
import com.example.cardmanagement.R
import com.example.cardmanagement.model.Service
import com.example.cardmanagement.screens.composables.FrequentlyUsedItem
import com.example.cardmanagement.screens.composables.ServiceItem
import com.example.cardmanagement.viewmodel.CardViewModel


@Composable
fun DashboardScreen(paddingValues: PaddingValues,
                    cardViewModel: CardViewModel = viewModel(),
                    navController: NavController) {


    var cardList = cardViewModel.cards
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        cardViewModel.loadCards(context)
    }

    val frequentlyUsed = listOf(
        FrequentlyUsedItem(
            "Mobile Recharge",
            R.drawable.phone,
            backgroundColor = Color(0xFFD1E8FF),
            iconColor = Color(0xFF2196F3)
        ),
        FrequentlyUsedItem(
            "Bill Payments",
            R.drawable.receipt,
            backgroundColor = Color(0xFFFFE0E0),
            iconColor = Color(0xFFE53935)
        ),
        FrequentlyUsedItem(
            "Bank Transfer",
            R.drawable.send,
            backgroundColor = Color(0xFFFFF8E1),
            iconColor = Color(0xFFFFA000)
        ),
        FrequentlyUsedItem(
            "Request Money",
            R.drawable.phonepe,
            backgroundColor = Color(0xFFEDE7F6),
            iconColor = Color(0xFF7E57C2)
        )
    )

    val services = listOf(
        Service(
            label = "Open Account",
            icon = R.drawable.account,
            backgroundColor = Color(0xFFFFF3E0),
            iconColor = Color(0xFFF57C00)
        ),
        Service(
            label = "Manage Cards",
            icon = R.drawable.wallet,
            backgroundColor = Color(0xFFE0F2F1),
            iconColor = Color(0xFF00796B)
        ),
        Service(
            label = "Travel Bookings",
            icon = R.drawable.travel,
            backgroundColor = Color(0xFFB9F6CA),
            iconColor = Color(0xFF3F51B5)
        ),
        Service(
            label = "Insurance",
            icon = R.drawable.insurance,
            backgroundColor = Color(0xFFFFF3E0),
            iconColor = Color(0xFFE53935)
        )

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp)
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            items(cardList) {
                CardItem(card = it, navController)
            }
        }

        Text(
            text = "Frequently Used",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(frequentlyUsed) { item ->
                FrequentlyUsedItem(item)
            }
        }

        Text(
            text = "Service",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(services.size) { item ->
                ServiceItem(service = services[item])
            }
        }

    }
}
