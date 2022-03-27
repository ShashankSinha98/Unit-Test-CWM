package com.shashank.unittestcwm.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shashank.unittestcwm.models.Note
import com.shashank.unittestcwm.persistence.NoteDao

@Database(entities = [ Note::class ], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    companion object {
        val DATABASE_NAME = "notes_db"
    }

    abstract fun getNoteDao(): NoteDao
}