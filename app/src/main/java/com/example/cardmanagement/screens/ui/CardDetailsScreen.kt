package com.example.cardmanagement.screens.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CardDetailsScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf("Month") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFF0F4FF))
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Current Balance",
                    color = Color.Gray
                )

                Text(
                    text = "$3,567.12",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color(0xFF4B66EA)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFFF3F5F9))
                .padding(6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TabButton("Day", selectedTab) { selectedTab = "Day" }
            TabButton("Month", selectedTab) { selectedTab = "Month" }
            TabButton("Yearly", selectedTab) { selectedTab = "Yearly" }
        }

        Spacer(modifier = Modifier.height(16.dp))

        FakeGraph()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Transactions History",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                TransactionItem(
                    title = "UBER Ride",
                    date = "27-Apr | 08:25pm",
                    amount = "-\$574.00",
                    isCredit = false
                )
            }

            item {
                TransactionItem(
                    title = "Received Money",
                    date = "25-Apr | 10:50am",
                    amount = "+\$2047.00",
                    isCredit = true
                )
            }

            item {
                TransactionItem(
                    title = "Grocery Purchase",
                    date = "22-Apr | 06:22pm",
                    amount = "-\$89.60",
                    isCredit = false
                )
            }

            item {
                TransactionItem(
                    title = "Added to Wallet",
                    date = "20-Apr | 02:18pm",
                    amount = "+\$500.00",
                    isCredit = true
                )
            }

            item {
                TransactionItem(
                    title = "Netflix Subscription",
                    date = "19-Apr | 08:00pm",
                    amount = "-\$499.00",
                    isCredit = false
                )
            }

            item {
                TransactionItem(
                    title = "ATM Withdrawal",
                    date = "16-Apr | 01:15pm",
                    amount = "-\$3000.00",
                    isCredit = false
                )
            }
        }
    }
}

@Composable
fun TransactionItem(title: String, date: String, amount: String, isCredit: Boolean) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(title, fontWeight = FontWeight.Bold)
            Text(date, color = Color.Gray, fontSize = 12.sp)
        }

        Text(
            amount,
            color = if (isCredit) Color(0xFF4CAF50) else Color(0xFFE53935),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun FakeGraph() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFF7F9FF))
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                moveTo(0f, size.height * 0.6f)
                cubicTo(
                    size.width * 0.2f, size.height * 0.4f,
                    size.width * 0.4f, size.height * 0.8f,
                    size.width * 0.5f, size.height * 0.5f
                )
                cubicTo(
                    size.width * 0.7f, size.height * 0.3f,
                    size.width * 0.9f, size.height * 0.6f,
                    size.width, size.height * 0.4f
                )
            }

            drawPath(
                path = path,
                color = Color(0xFF4B66EA),
                style = Stroke(width = 6f)
            )
        }
    }
}

@Composable
fun TabButton(text: String, selectedTab: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(if (selectedTab == text) Color(0xFF4B66EA) else Color.Transparent)
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Text(
            text,
            color = if (selectedTab == text) Color.White else Color.Gray
        )
    }
}


