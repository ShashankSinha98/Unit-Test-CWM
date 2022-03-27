package com.shashank.unittestcwm.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shashank.unittestcwm.models.Note
import io.reactivex.Single

@Dao
interface NoteDao {

    // Long- row no where data is inserted, -1 if not inserted
    @Insert
    @Throws(Exception::class)
    fun insertNote(note: Note): Single<Long>

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Note>>

    @Delete
    @Throws(Exception::class)
    fun deleteNote(note: Note): Single<Int>

    @Update
    @Throws(Exception::class)
    fun updateNote(note: Note): Single<Int>

}