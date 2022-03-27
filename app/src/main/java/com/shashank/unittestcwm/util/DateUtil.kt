package com.shashank.unittestcwm.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    companion object {
        private const val TAG = "DateUtil"

        val monthNumbers = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12")
        val months = listOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")

        const val GET_MONTH_ERROR = "Error. Invalid month number."
        private const val DATE_FORMAT = "MM-yyyy"



        @Throws(Exception::class)
        fun getCurrentTimestamp(): String {
            try {
                val dateFormat = SimpleDateFormat(DATE_FORMAT)
                return dateFormat.format(Date())
            } catch (e: Exception) {
                e.printStackTrace()
                throw Exception("Couldn't format date into MM-yyyy")
            }
        }

        fun getMonthFromNumber(monthNumber: String): String {
            return when (monthNumber) {
                "01" -> {
                    months[0]
                }
                "02" -> {
                    months[1]
                }
                "03" -> {
                    months[2]
                }
                "04" -> {
                    months[3]
                }
                "05" -> {
                    months[4]
                }
                "06" -> {
                    months[5]
                }
                "07" -> {
                    months[6]
                }
                "08" -> {
                    months[7]
                }
                "09" -> {
                    months[8]
                }
                "10" -> {
                    months[9]
                }
                "11" -> {
                    months[10]
                }
                "12" -> {
                    months[11]
                }
                else -> {
                    GET_MONTH_ERROR
                }
            }
        }

    }


}