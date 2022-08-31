package za.co.sikabopha.absaweather.data.entity

data class Data(val timelines: List<Timeline>)

data class Interval(val startTime: String, val values: Values)

data class Values(val temperature: Double)

data class Root(
    var data: Data? = null
)

data class Timeline(
    val timestamp: String,
    val endTime: String,
    val startTime: String,
    val intervals: List<Interval>
)


