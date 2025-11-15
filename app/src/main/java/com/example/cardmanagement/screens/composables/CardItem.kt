package com.example.cardmanagement.screens.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cardmanagement.model.Card

@Composable
fun CardItem(card: Card,
             navController: NavController
) {
    Card(
        modifier = Modifier
            .width(350.dp)
            .height(230.dp)
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = card.cardColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
                .clickable {
                    navController.navigate("card_details")
                },
        ) {
            Text(text = card.bankName, fontSize = 16.sp, color = Color.White)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "**** **** **** ${card.cardNumber.takeLast(4)}", fontSize = 18.sp, color = Color.White)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = card.cardName, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Exp ${card.expiryDate}", fontSize = 16.sp, color = Color.White)
                Text(text = card.cardType, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}