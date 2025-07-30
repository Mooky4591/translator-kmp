package com.example.translator_kmm.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val fromLanguageCode: String,
    val fromText: String,
    val toLanguageCode: String,
    val toText: String,
    val timeStamp: Int? = null
)
