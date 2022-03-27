package com.shashank.unittestcwm.util


import com.shashank.unittestcwm.models.Note

class TestUtil {
    companion object {
        val TIMESTAMP_1 = "05-2019"
        val TEST_NOTE_1 = Note("Take out the trash", "It's garbage day tomorrow.", TIMESTAMP_1)

        val TIMESTAMP_2 = "06-2019"
        val TEST_NOTE_2 = Note("Anniversary gift", "Buy an anniversary gift.", TIMESTAMP_2)

        val TEST_NOTES_LIST: List<Note> = listOf<Note>(
            Note("Take out the trash", "It's garbage day tomorrow.", TIMESTAMP_1) ,
            Note("Anniversary gift", "Buy an anniversary gift.", TIMESTAMP_2)
        )
    }

}