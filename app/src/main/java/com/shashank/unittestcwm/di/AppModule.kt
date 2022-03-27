package com.shashank.unittestcwm.di

import android.app.Application
import androidx.room.Room
import com.shashank.unittestcwm.persistence.NoteDao
import com.shashank.unittestcwm.persistence.NoteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

        @Singleton
        @Provides
        fun provideNoteDatabase(application: Application) : NoteDatabase {
            return Room.databaseBuilder(
                application,
                NoteDatabase::class.java,
                NoteDatabase.DATABASE_NAME,
            ).build()
        }


        @Singleton
        @Provides
        fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
            return noteDatabase.getNoteDao()
        }

}