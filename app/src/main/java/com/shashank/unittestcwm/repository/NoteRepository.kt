package com.shashank.unittestcwm.repository

import com.shashank.unittestcwm.models.Note
import com.shashank.unittestcwm.persistence.NoteDao
import com.shashank.unittestcwm.ui.Resource
import io.reactivex.Flowable
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
import io.reactivex.schedulers.Schedulers
import java.lang.Exception


@Singleton
class NoteRepository
    @Inject constructor(private val noteDao: NoteDao) {

    companion object {
        private val NOTE_TITLE_NULL = "Note title cannot be null"
        private val INVALID_NOTE_ID = "Invalid id. Can't delete note"
        private val DELETE_SUCCESS = "Delete success"
        private val DELETE_FAILURE = "Delete failure"
        private val UPDATE_SUCCESS = "Update success"
        private val UPDATE_FAILURE = "Update failure"
        private val INSERT_SUCCESS = "Insert success"
        private val INSERT_FAILURE = "Insert failure"

        private val timeDelay: Long = 0
        private val timeUnit = TimeUnit.SECONDS
    }


    fun insertNote(note: Note): Flowable<Resource<Int>> {
        return noteDao.insertNote(note)
            .delaySubscription(timeDelay, timeUnit)
            .map<Int>{ rowLong: Long ->
                rowLong as Int
            }.onErrorReturn { -1 }
            .map<Resource<Int>>{ rowInt: Int ->
                if(rowInt>0) {
                    Resource.success(rowInt, INSERT_SUCCESS)
                } else Resource.error(null, INSERT_FAILURE)
            }.subscribeOn(Schedulers.io()) // work on background thread
            .toFlowable() // we will convert it to livedata later
    }

}