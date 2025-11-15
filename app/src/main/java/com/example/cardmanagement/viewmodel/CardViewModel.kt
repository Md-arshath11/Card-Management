package com.example.cardmanagement.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardmanagement.model.Card
import com.example.cardmanagement.pref.CardDataStore
import kotlinx.coroutines.launch

class CardViewModel: ViewModel(){

    private val _cards = mutableStateListOf<Card>()
    val cards: List<Card> = _cards


        suspend fun loadCards(context: Context) {
            val dataStore = CardDataStore(context)
            val saved = dataStore.loadCards()
            if (saved.isEmpty()) {
                _cards.addAll(
                    listOf(
                        Card("Dutch Bangla Bank", "1234567890121690", "VISA", "01/26", Color(0xFF2C2C2C), "Platinum Plus"),
                        Card("Canara Bank", "1234567890123456", "Mastercard", "05/26", Color(0xFF7B4EFF), "Platinum Plus"),
                        Card("SBI", "1234 5678 9012 7888", "VISA", "03/27", Color(0xFF5CC9A2), "Business Card"),
                        Card("IOB", "1234 5678 9012 7123", "VISA", "03/28", Color(0xFFFFA726), "Premium Card"),
                    )
                )
                saveCards(context)
            } else {
                _cards.clear()
                _cards.addAll(saved)
            }
        }

        suspend fun saveCards(context: Context) {
            val dataStore = CardDataStore(context)
            dataStore.saveCards(_cards)
        }

        fun addCard(context: Context, newCard: Card) {
            viewModelScope.launch {
                _cards.add(newCard)
                saveCards(context)
            }
        }
    }

