package com.shashank.unittestcwm.repository

import com.shashank.unittestcwm.persistence.NoteDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository
    @Inject constructor(private val noteDao: NoteDao) {

}