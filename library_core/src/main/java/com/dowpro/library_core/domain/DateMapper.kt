package com.dowpro.library_core.domain

import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

// https://m2.material.io/design/communication/data-formats.html#date-and-time
// https://m1.material.io/patterns/data-formats.html
// TODO: Implement date formats that correspond with the suggestions from material design. Currently m3 lacks the above.
// https://medium.com/nanogiants/handling-dates-on-android-1fccccde9d54
class DateMapper {

    /*
    Within the current day, use uppercase AM or PM, without periods (or lowercase am/pm, if suitable for the locale).
    Otherwise, Display the time without AM/PM.

    Examples:
        2:00 PM
        14:00
     */
    fun getTime(date: LocalDateTime): String {
        return ""
    }

    /*
    Show the date with the year. If it’s within the current calendar year, don’t show the year.

    Examples
        January 14
        14 January 2012
     */
    fun getMonthDayYear(date: LocalDateTime): String {
        return ""
    }

    /*
    Approximate time

    Round down to the largest and most recent date or time.

    Examples:
        In 5 minutes
        3 days ago
     */
    fun getApproximateTime(date: LocalDateTime): String {
        return ""
    }

    /*
    Absolute time

    When approximate time isn’t appropriate, display the specific date or time.

    Examples:
        Today, 10:00 AM
    */
    fun getAbsoluteTime(date: LocalDateTime): String {
        return ""
    }

    /*
    Date ranges are formatted based on whether the range covers the same year or the current year:
       • Show the year on both the start and end
       • If both dates have the current year, show the year only on the end of the range

    Example
        Dec 6, 2013–Jan 2, 2014
        January 4–6, 2014
     */

    fun getTimeRange(date: LocalDateTime, date2: LocalDateTime): String {
        return ""
    }

    /*
    Use a single AM or PM at the end of the range, if both times have the same AM/PM.

    Example:
        8:00–10:30 AM
     */
    fun getDateRange(date: LocalDateTime, date2: LocalDateTime): String {
        return ""
    }


}