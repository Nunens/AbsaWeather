package za.co.sikabopha.absaweather.data.entity

data class Timeline(
    val timestamp: String,
    val endtime: String,
    val startTime: String,
    val intervals: Interval
)
