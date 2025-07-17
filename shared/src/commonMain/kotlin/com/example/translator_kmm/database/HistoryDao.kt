package com.example.translator_kmm.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history ORDER BY timeStamp DESC")
    fun getHistory(): Flow<List<History>>

    @Upsert
    suspend fun upsertHistory(history: History)

}
