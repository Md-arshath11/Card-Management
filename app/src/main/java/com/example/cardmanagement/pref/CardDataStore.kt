package com.example.cardmanagement.pref

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.cardmanagement.model.Card
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.first

val Context.cardDataStore by preferencesDataStore("card_storage")

object CardKeys {
    val CARD_LIST = stringPreferencesKey("card_list_json")
}

class CardDataStore(private val context: Context) {

    private val gson = Gson()

    suspend fun saveCards(cards: List<Card>) {
        val json = gson.toJson(cards)

        context.cardDataStore.edit { prefs ->
            prefs[CardKeys.CARD_LIST] = json
        }
    }
    suspend fun loadCards(): List<Card> {
        val prefs = context.cardDataStore.data.first()
        val json = prefs[CardKeys.CARD_LIST] ?: return emptyList()

        val type = object : TypeToken<List<Card>>() {}.type
        return gson.fromJson(json, type)
    }
}

