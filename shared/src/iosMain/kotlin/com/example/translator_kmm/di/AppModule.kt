package com.example.translator_kmm.di

import androidx.room.InvalidationTracker
import com.example.translator_kmm.core.domain.language.Language
import com.example.translator_kmm.core.presentation.UiLanguage
import com.example.translator_kmm.database.History
import com.example.translator_kmm.database.HistoryDao
import com.example.translator_kmm.database.TranslatorDatabase
import com.example.translator_kmm.database.getDatabase
import com.example.translator_kmm.translate.data.remote.HttpClientFactory
import com.example.translator_kmm.translate.data.translate.KtorTranslateClient
import com.example.translator_kmm.translate.domain.translate.Translate
import com.example.translator_kmm.translate.domain.translate.TranslateClient
import kotlinx.coroutines.flow.Flow

class AppModule {
    val historyDao: HistoryDao = getDatabase().historyDao()

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    val translate: Translate = Translate(
        client = translateClient,
        historyDataSource = historyDao
    )
}