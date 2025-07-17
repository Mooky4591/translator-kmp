package com.example.translator_kmm.translate.domain.translate

import com.example.translator_kmm.database.History
import com.example.translator_kmm.core.domain.language.Language
import com.example.translator_kmm.core.domain.util.Resource
import com.example.translator_kmm.database.HistoryDao

class Translate (
    private val client: TranslateClient,
    private val historyDataSource: HistoryDao
) {

    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        return try {
            val translatedText = client.translate(
                fromLanguage = fromLanguage,
                fromText = fromText,
                toLanguage = toLanguage
            )
            historyDataSource.upsertHistory(
                history = History(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText,
                    timeStamp = 0)
            )
            Resource.Success(translatedText)
        } catch (e: TranslateException) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }

}