package com.rmakiyama.androidthemestudy.di

import android.app.Application
import android.content.Context
import com.rmakiyama.androidthemestudy.data.UserStatusSetting
import com.rmakiyama.androidthemestudy.data.UserStatusSettingImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideAppContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideUserStatusSetting(context: Context): UserStatusSetting {
        return UserStatusSettingImpl(context)
    }
}
