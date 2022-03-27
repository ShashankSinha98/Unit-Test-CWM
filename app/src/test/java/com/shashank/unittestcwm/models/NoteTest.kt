package com.shashank.unittestcwm.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class NoteTest {

    companion object {
        private const val TIMESTAMP_1 = "05-2021"
        private const val TIMESTAMP_2 = "04-2021"
    }


    /*
     * Compare 2 equal notes
     * */
    // internal- it will be visible everywhere in the same module.
    @Test
    @Throws(Exception::class)
    internal fun isNotesEqual_identicalProperties_returnTrue()  {
        // Arrange
        val note1 = Note(1,"Note #1", "This is note #1", TIMESTAMP_1)
        val note2 = Note(1,"Note #1", "This is note #1", TIMESTAMP_1)

        // Act

        // Assert
        assertEquals(note1, note2)
        println("The notes are equal!")
    }


    /**
     * Compare notes with 2 different ids
     * */
    @Test
    @Throws(Exception::class)
    internal fun isNotesEqual_differentIds_returnFalse() {
        // Arrange
        val note1 = Note(1,"Note #1", "This is note #1", TIMESTAMP_1)
        val note2 = Note(2,"Note #1", "This is note #1", TIMESTAMP_1)

        // Act

        // Assert
        assertNotEquals(note1, note2)
        println("The notes are not equal!")
    }


    /**
     * Compare notes with 2 different Timestamps
     * */
    @Test
    @Throws(Exception::class)
    internal fun isNotesEqual_differentTimestamps_returnTrue() {
        // Arrange
        val note1 = Note(1,"Note #1", "This is note #1", TIMESTAMP_1)
        val note2 = Note(1,"Note #1", "This is note #1", TIMESTAMP_2)

        // Act

        // Assert
        assertEquals(note1, note2)
        println("The notes are equal!")
    }


    /**
     * Compare notes with 2 different Titles
     * */
    @Test
    @Throws(Exception::class)
    internal fun isNotesEqual_differentTitles_returnFalse() {
        // Arrange
        val note1 = Note(1,"Note #1", "This is note #1", TIMESTAMP_1)
        val note2 = Note(1,"Note #2", "This is note #1", TIMESTAMP_1)

        // Act

        // Assert
        assertNotEquals(note1, note2)
        println("The notes are not equal! They have different titles")
    }


    /**
     * Compare notes with 2 different Content
     * */
    @Test
    @Throws(Exception::class)
    internal fun isNotesEqual_differentContent_returnFalse() {
        // Arrange
        val note1 = Note(1,"Note #1", "This is note #1", TIMESTAMP_1)
        val note2 = Note(1,"Note #1", "This is note #2", TIMESTAMP_1)

        // Act

        // Assert
        assertNotEquals(note1, note2)
        println("The notes are not equal! They have different content")
    }


}