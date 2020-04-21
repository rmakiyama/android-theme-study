package com.rmakiyama.androidthemestudy.data

import com.rmakiyama.androidthemestudy.model.Dummy
import kotlinx.coroutines.flow.Flow

interface DummyRepository {

    fun dummies(): Flow<List<Dummy>>

    suspend fun save(dummy: Dummy)
}
