package com.example.translator_kmm.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getDatabase(context: Context): TranslatorDatabase {
    val dbFile = context.getDatabasePath("translator.db")
    return Room.databaseBuilder<TranslatorDatabase>(
        context = context,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}