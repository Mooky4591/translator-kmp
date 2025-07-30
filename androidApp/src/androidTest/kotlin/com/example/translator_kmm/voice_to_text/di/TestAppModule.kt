package com.example.translator_kmm.voice_to_text.di

import com.example.translator_kmm.android.di.AppModule
import com.example.translator_kmm.android.voice_to_text.di.VoiceToTextModule
import com.example.translator_kmm.database.HistoryDao
import com.example.translator_kmm.translate.data.local.FakeHistoryDataSource
import com.example.translator_kmm.translate.data.remote.FakeTranslateClient
import com.example.translator_kmm.translate.domain.translate.Translate
import com.example.translator_kmm.translate.domain.translate.TranslateClient
import com.example.translator_kmm.voice_to_text.data.FakeVoiceToTextParser
import com.example.translator_kmm.voice_to_text.domain.VoiceToTextParser
import dagger.hilt.components.SingletonComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class, VoiceToTextModule::class]
)
object TestAppModule {

    @Provides
    @Singleton
    fun provideFakeTranslateClient(): TranslateClient {
        return FakeTranslateClient()
    }

    @Provides
    @Singleton
    fun provideFakeHistoryDataSource(): HistoryDao {
        return FakeHistoryDataSource()
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDao
    ): Translate {
        return Translate(client, dataSource)
    }

    @Provides
    @Singleton
    fun provideFakeVoiceToTextParser(): VoiceToTextParser {
        return FakeVoiceToTextParser()
    }
}