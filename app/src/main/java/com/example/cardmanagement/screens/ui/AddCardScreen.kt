package com.example.cardmanagement.screens.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cardmanagement.R
import com.example.cardmanagement.model.Card
import com.example.cardmanagement.viewmodel.CardViewModel

@Composable
fun AddCardScreen(
    padding: PaddingValues,
    navController: NavController,
    cardViewModel: CardViewModel
) {

    val context = LocalContext.current

    var holderName by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var cardType by remember { mutableStateOf("") }
    var expiry by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    val cardTypes = listOf("VISA", "Mastercard")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.wallets),
                contentDescription = "Add Card",
                modifier = Modifier
                    .size(180.dp)
                    .padding(top = 20.dp, bottom = 10.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text("Bank Name", color = MaterialTheme.colorScheme.onSurface)
            OutlinedTextField(
                value = holderName,
                onValueChange = { holderName = it },
                placeholder = { Text("SBI") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                shape = RoundedCornerShape(14.dp)
            )

            Text("Card Number", color = MaterialTheme.colorScheme.onSurface)
            OutlinedTextField(
                value = cardNumber,
                onValueChange = { cardNumber = it },
                placeholder = { Text("XXXX XXXX XXXX") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                shape = RoundedCornerShape(14.dp)
            )

            Text("Card Type", color = MaterialTheme.colorScheme.onSurface)

            var expanded by remember { mutableStateOf(false) }
            Box{
                OutlinedButton(
                    onClick = { expanded = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
                ) {
                    Text(text = if (cardType.isEmpty()) "Choose one" else cardType)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }

                DropdownMenu(expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    cardTypes.forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                cardType = it
                                expanded = false
                            }
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(Modifier.weight(1f)) {
                    Text("Expiry", color = MaterialTheme.colorScheme.onSurface)
                    OutlinedTextField(
                        value = expiry,
                        onValueChange = { expiry = it },
                        placeholder = { Text("MM/YY") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        shape = RoundedCornerShape(14.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(Modifier.weight(1f)) {
                    Text("CVV", color = MaterialTheme.colorScheme.onSurface)
                    OutlinedTextField(
                        value = cvv,
                        onValueChange = { cvv = it },
                        placeholder = { Text("XXX") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        shape = RoundedCornerShape(14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (holderName.isNotEmpty() && cardNumber.isNotEmpty() &&
                        cardType.isNotEmpty() && expiry.isNotEmpty()
                    ) {

                        val newCard = Card(
                            bankName = holderName,
                            cardNumber = cardNumber,
                            cardType = cardType,
                            expiryDate = expiry,
                            cardColor = Color(0xFF7B4EFF),
                            cardName = "Platinum Plus"
                        )

                        cardViewModel.addCard(context,newCard)

                        navController.popBackStack()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5F8BFF)
                )
            ) {
                Text("Add Card", color = Color.White)
            }
        }
    }
