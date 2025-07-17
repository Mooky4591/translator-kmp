package com.example.translator_kmm.voice_to_text.domain

data class VoiceToTextParserState(
    val result: String = "",
    val isSpeaking: Boolean = false,
    val error: String? = null,
    val powerRation: Float = 0f
)
