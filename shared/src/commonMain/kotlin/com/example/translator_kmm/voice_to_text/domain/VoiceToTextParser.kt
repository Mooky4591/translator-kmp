package com.example.translator_kmm.voice_to_text.domain

import com.example.translator_kmm.core.domain.util.CommonStateFlow

interface VoiceToTextParser {
    val state: CommonStateFlow<VoiceToTextParserState>
    fun startListening(languageCode: String)
    fun stopListening()
    fun cancel()
    fun reset()

}