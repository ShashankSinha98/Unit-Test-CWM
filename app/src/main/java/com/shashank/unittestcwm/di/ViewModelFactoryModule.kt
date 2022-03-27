package com.shashank.unittestcwm.di

import androidx.lifecycle.ViewModelProvider
import com.shashank.unittestcwm.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(providerFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}