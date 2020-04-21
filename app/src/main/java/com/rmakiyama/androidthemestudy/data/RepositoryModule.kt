package com.rmakiyama.androidthemestudy.data

import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun dummyRepository(impl: AppDummyRepository): DummyRepository
}
