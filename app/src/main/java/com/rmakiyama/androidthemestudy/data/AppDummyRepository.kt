package com.rmakiyama.androidthemestudy.data

import com.rmakiyama.androidthemestudy.model.Dummy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AppDummyRepository @Inject constructor() : DummyRepository {

    override fun dummies(): Flow<List<Dummy>> {
        return flow {
            emit(
                listOf(
                    Dummy(), Dummy(), Dummy(), Dummy(), Dummy(), Dummy(), Dummy()
                )
            )
        }
    }

    override suspend fun save(dummy: Dummy) {
        TODO("Not yet implemented")
    }
}
