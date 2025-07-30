package com.example.translator_kmm.translate.data.local

import com.example.translator_kmm.core.domain.util.toCommonFlow
import com.example.translator_kmm.database.History
import com.example.translator_kmm.database.HistoryDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeHistoryDataSource: HistoryDao {

    private val _data = MutableStateFlow<List<History>>(emptyList())

    override fun getHistory(): Flow<List<History>> {
        return _data.toCommonFlow()
    }

    override suspend fun upsertHistory(history: History) {
        _data.value += history
    }
}