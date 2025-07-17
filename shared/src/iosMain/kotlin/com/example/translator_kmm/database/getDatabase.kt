package com.example.translator_kmm.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getDatabase(): TranslatorDatabase {
    val dbFile = NSHomeDirectory() + "/translator.db"

    return Room.databaseBuilder<TranslatorDatabase>(
        name = dbFile,
        factory = { TranslatorDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}
