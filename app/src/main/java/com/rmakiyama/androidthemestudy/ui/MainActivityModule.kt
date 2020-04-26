package com.rmakiyama.androidthemestudy.ui

import com.rmakiyama.androidthemestudy.di.AssistedInjectModule
import com.rmakiyama.androidthemestudy.di.PageScope
import com.rmakiyama.androidthemestudy.ui.cases.dialog.DialogCaseFragment
import com.rmakiyama.androidthemestudy.ui.cases.pro.ProCaseFragment
import com.rmakiyama.androidthemestudy.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @PageScope
    @ContributesAndroidInjector(modules = [AssistedInjectModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @PageScope
    @ContributesAndroidInjector(modules = [AssistedInjectModule::class])
    abstract fun contributeDialogCaseFragment(): DialogCaseFragment

    @PageScope
    @ContributesAndroidInjector(modules = [AssistedInjectModule::class])
    abstract fun contributeProCaseFragment(): ProCaseFragment
}
