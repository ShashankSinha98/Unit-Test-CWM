package com.shashank.unittestcwm

import android.database.sqlite.SQLiteConstraintException
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.shashank.unittestcwm.models.Note
import com.shashank.unittestcwm.util.LiveDataTestUtil
import com.shashank.unittestcwm.util.TestUtil
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*


class NoteDaoTest: NoteDatabaseTest() {

    companion object {
        private val TEST_TITLE = "This is a test title"
        private val TEST_CONTENT = "This is some test content"
        private val TEST_TIMESTAMP = "08-2018"

    }

    @get: Rule
    val rule = InstantTaskExecutorRule()

    /**
            Insert, Read, Delete
     */
    @Test
    @Throws(Exception::class)
    fun insertReadDelete() {
        val note = Note(TestUtil.TEST_NOTE_1)

        // insert
        getNoteDao().insertNote(note).blockingGet() // wait until inserted

        // read
        val liveDataTestUtil = LiveDataTestUtil<List<Note>>()
        var insertedNotes: List<Note>? = liveDataTestUtil.getValue(getNoteDao().getNotes())

        assertNotNull(insertedNotes)
        assertEquals(1, insertedNotes!!.size)

        assertEquals(note.title, insertedNotes[0]!!.title)
        assertEquals(note.timestamp, insertedNotes[0].timestamp)
        assertEquals(note.content, insertedNotes[0].content)

        note.id = insertedNotes[0].id

        assertEquals(note, insertedNotes[0])

        // delete
        getNoteDao().deleteNote(note).blockingGet()

        // confirm the database is empty
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())
        assertEquals(0, insertedNotes?.size)
    }


    /**
            Insert, Read, Update, Read, Delete
     * */

    @Test
    @Throws(Exception::class)
    fun insertReadUpdateReadDelete() {

        val note = TestUtil.TEST_NOTE_1

        // insert
        getNoteDao().insertNote(note).blockingGet()

        // read
        val liveDataTestUtil = LiveDataTestUtil<List<Note>>()
        var insertedNotes: List<Note>? = liveDataTestUtil.getValue(getNoteDao().getNotes())

        assertNotNull(insertedNotes)
        assertEquals(1, insertedNotes!!.size)

        assertEquals(note.content, insertedNotes[0]!!.content)
        assertEquals(note.title, insertedNotes[0].title)
        assertEquals(note.timestamp, insertedNotes[0].timestamp)

        note.id = insertedNotes[0].id
        assertEquals(note, insertedNotes[0])

        // Update
        note.title = TEST_TITLE
        note.content = TEST_CONTENT
        note.timestamp = TEST_TIMESTAMP
        getNoteDao().updateNote(note).blockingGet()

        // read
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())

        assertNotNull(insertedNotes)
        assertEquals(1, insertedNotes!!.size)

        assertEquals(TEST_TITLE, insertedNotes[0].title)
        assertEquals(TEST_CONTENT, insertedNotes[0].content)
        assertEquals(TEST_TIMESTAMP, insertedNotes[0].timestamp)

        note.id = insertedNotes[0].id
        assertEquals(note, insertedNotes[0])

        // delete
        getNoteDao().deleteNote(note).blockingGet()

        // confirm the database is empty
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes())

        assertNotNull(insertedNotes)
        assertEquals(0, insertedNotes!!.size)
    }
}