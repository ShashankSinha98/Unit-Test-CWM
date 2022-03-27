package com.shashank.unittestcwm.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note (
    @NonNull
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "content")
    var content: String?,

    @ColumnInfo(name = "timestamp")
    var timestamp: String
) : Parcelable {


    @PrimaryKey(autoGenerate = true)
    var id: Long = System.currentTimeMillis() // default id

    constructor(note: Note): this(note.title, note.content, note.timestamp) {
        this.id = id
    }



    // 2 notes are equal only if their id, title and content are same
    override fun equals(obj: Any?): Boolean {

        if(obj==null) return false

        // checking if obj belong to Note class
        if(javaClass!=obj.javaClass) return false

        val note = obj as Note
        return note.id == id && note.title == title && note.content == content
    }
}
