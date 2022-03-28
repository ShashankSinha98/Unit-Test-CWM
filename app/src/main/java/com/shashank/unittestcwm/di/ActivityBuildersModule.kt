package com.shashank.unittestcwm.di

import com.shashank.unittestcwm.ui.noteslist.NotesListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeNotesListActivity(): NotesListActivity
}