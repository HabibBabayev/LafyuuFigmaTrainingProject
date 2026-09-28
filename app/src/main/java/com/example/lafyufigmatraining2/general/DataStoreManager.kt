package com.example.lafyufigmatraining2.general

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class DataStoreManager @Inject constructor(
    @ApplicationContext private val context: Context
){

    companion object{
        private val TOKEN= stringPreferencesKey("token")
    }
    suspend fun addToken(token: String?){
        context.preferenceDataStore.edit { pref->
            pref[TOKEN]=token?:""
        }
    }
    fun getToken(): Flow<String?> {
            val token =context.preferenceDataStore.data.map {
                it[TOKEN] ?:""
            }
        return token
    }
}

//const val USER_DATASTORE="user_data"
//val Context.preferenceDataStore: DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)
//class DataStoreManager(val context: Context) {
//    companion object {
//        val USERNAME= stringPreferencesKey("username")?:""
//        val PASSWORD= stringPreferencesKey("password")
//        val EMAIL=stringPreferencesKey("email")
//
//    }
//    suspend fun saveToDataStore(userDetails: LoginRequestModel){
//        context.preferenceDataStore.edit {
//            it[USERNAME] =userDetails.username
//            it[PASSWORD]=userDetails.password
//        }
//
//
//    }
//}