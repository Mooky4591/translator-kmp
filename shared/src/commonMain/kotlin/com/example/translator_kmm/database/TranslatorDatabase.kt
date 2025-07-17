package com.example.translator_kmm.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        History::class
        ],
    version = 1
)
abstract class TranslatorDatabase: RoomDatabase() {

    abstract fun historyDao(): HistoryDao

}