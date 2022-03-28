package com.shashank.unittestcwm.ui

import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class Resource<T> (
    val status: Status,
    val data: T?=null,
    val message: String?=null) {

    companion object {

        fun <T> success(data: T, message: String): Resource<T> {
            return Resource(Status.SUCCESS, data, message)
        }

        fun <T> error(data: T?, message: String): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }


    override fun equals(obj: Any?): Boolean {
        if (obj?.javaClass != javaClass || obj.javaClass != Resource::class.java) {
            return false
        }
        val resource: Resource<*> = obj as Resource<*>
        if (resource.status !== status) {
            return false
        }
        if (data != null) {
            if (resource.data !== data) {
                return false
            }
        }
        if (resource.message != null) {
            if (message == null) {
                return false
            }
            if (resource.message != message) {
                return false
            }
        }
        return true
    }


    enum class Status {
        SUCCESS, ERROR, LOADING
    }
}