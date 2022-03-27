package com.shashank.unittestcwm

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.shashank.unittestcwm.persistence.NoteDao
import com.shashank.unittestcwm.persistence.NoteDatabase
import org.junit.After
import org.junit.Before

// junit - JUnit4: for backward compatibility
abstract class NoteDatabaseTest {

    // system under test
    private var noteDatabase: NoteDatabase?=null


    fun getNoteDao(): NoteDao {
        return noteDatabase!!.getNoteDao()
    }

    @Before
    fun init() {
        // creating mock database for testing and getting application context
        noteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        ).build()
    }

    @After
    fun finish() {
        // clean up resources
        noteDatabase!!.close()
    }

}