package com.example.translator_kmm.translate.presentation

import com.example.translator_kmm.core.presentation.UiLanguage
import com.example.translator_kmm.translate.domain.translate.TranslateError

data class TranslateState(
    val fromText: String = "",
    val toText: String? = null,
    val isTranslating: Boolean = false,
    val fromLanguage: UiLanguage = UiLanguage.Companion.byCode("en"),
    val toLanguage: UiLanguage = UiLanguage.Companion.byCode("de"),
    val isChoosingFromLanguage: Boolean = false,
    val isChoosingToLanguage: Boolean = false,
    val error: TranslateError? = null,
    val history: List<UiHistoryItem> = emptyList()
)
