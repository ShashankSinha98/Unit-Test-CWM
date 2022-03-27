package com.shashank.unittestcwm.util

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.util.*

// junit.jupiter - JUnit5
class DateUtilTest {

    companion object {
        private const val TODAY = "03-2022"
    }

    @Test
    internal fun testGetCurrentTimestamp_returnedTimestamp() {
        assertDoesNotThrow {
            assertEquals(TODAY, DateUtil.getCurrentTimestamp())
            println("Timestamp is generated correctly!")
        }
    }


    /**
     *  below test will run for each no's in value source. It will be passed to month number.
     *  testInfo and testReporter are params provided when we use @ParameterizedTest. Provide more info about test
     *  (Not compulsory to include in all @ParameterizedTest)
     * */
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    internal fun getMonthFromNumber_returnSuccess(monthNumber: Int, testInfo: TestInfo, testReporter: TestReporter) {
        assertEquals(DateUtil.months[monthNumber], DateUtil.getMonthFromNumber(DateUtil.monthNumbers[monthNumber]))
        println(DateUtil.monthNumbers[monthNumber]+" : "+DateUtil.months[monthNumber])
    }

    @ParameterizedTest
    @ValueSource(ints = [1,2,3,4,5,6,7,8,9,10,11])
    internal fun testGetMonthFromNumber_returnError(monthNumber: Int, testInfo: TestInfo, testReporter: TestReporter) {
        val randomInt = Random().nextInt(90) + 13
        assertEquals(DateUtil.getMonthFromNumber((monthNumber *randomInt).toString()), DateUtil.GET_MONTH_ERROR)
        println(DateUtil.monthNumbers[monthNumber]+" : "+DateUtil.GET_MONTH_ERROR)
    }
}