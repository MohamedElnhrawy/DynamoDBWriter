package com.example.common

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import java.time.temporal.TemporalQueries.localDate





fun Long.getFormatTime(): String? {
    val currentTime: Date = Date(this * 1000)
    val timeZoneDate = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    return timeZoneDate.format(currentTime)
}
fun String.getFormatTime(date: String): String {
   return date.split(" ")[0]
}