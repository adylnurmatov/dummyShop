package com.example.dummyshop.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "auth_store")

class TokenManager(private val context: Context) {
    private val KEY_TOKEN = stringPreferencesKey("token")
    private val KEY_USER_ID = intPreferencesKey("user_id")

    val tokenFlow: Flow<String?> = context.dataStore.data.map { it[KEY_TOKEN] }
    val userIdFlow: Flow<Int?> = context.dataStore.data.map { it[KEY_USER_ID] }

    suspend fun saveToken(token: String?) {
        context.dataStore.edit { prefs ->
            if (token == null) prefs.remove(KEY_TOKEN) else prefs[KEY_TOKEN] = token
        }
    }

    suspend fun saveUserId(userId: Int?) {
        context.dataStore.edit { prefs ->
            if (userId == null) prefs.remove(KEY_USER_ID) else prefs[KEY_USER_ID] = userId
        }
    }
}


