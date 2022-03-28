package com.shashank.unittestcwm.repository

import com.shashank.unittestcwm.models.Note
import com.shashank.unittestcwm.persistence.NoteDao
import org.junit.Assert
import org.junit.Assert.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NoteRepositoryTest {

    // system under test
    private lateinit var noteRepository: NoteRepository

    //@Mock
    private lateinit var noteDao: NoteDao

    @BeforeEach
    fun initEach() {
        // MockitoAnnotations.initMocks(this)
        noteDao = Mockito.mock(NoteDao::class.java)
        noteRepository = NoteRepository(noteDao)
    }

    @Test
    @Throws(Exception::class)
    fun dummyTest() {
        assertNotNull(noteDao)
        assertNotNull(noteRepository)
    }
}