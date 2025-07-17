package com.example.translator_kmm.android.di

import android.content.Context
import androidx.room.Room
import com.example.translator_kmm.database.HistoryDao
import com.example.translator_kmm.database.TranslatorDatabase
import com.example.translator_kmm.translate.data.remote.HttpClientFactory
import com.example.translator_kmm.translate.data.translate.KtorTranslateClient
import com.example.translator_kmm.translate.domain.translate.Translate
import com.example.translator_kmm.translate.domain.translate.TranslateClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient



@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TranslatorDatabase {
        return Room.databaseBuilder(
            context,
            TranslatorDatabase::class.java,
            "Translator_Database"
        ).build()
    }

    @Provides
    fun provideHistoryDao(db: TranslatorDatabase): HistoryDao {
        return db.historyDao()
    }

    @Provides
    fun provideTranslateUseCase(
        client: TranslateClient,
        dao: HistoryDao
    ): Translate {
        return Translate(client, dao)
    }
}