package com.shashank.unittestcwm.ui.noteslist

import android.os.Bundle
import android.util.Log
import com.shashank.unittestcwm.R
import com.shashank.unittestcwm.repository.NoteRepository
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NotesListActivity : DaggerAppCompatActivity() {

    private val TAG = "NotesListActivity"

    @Inject
    lateinit var noteRepository: NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "noteRepository: $noteRepository")

    }
}