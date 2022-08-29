package za.co.sikabopha.absaweather.domain.model

data class Weather(
    val days: String,
    val startTime: String,
    val endTime: String,
    val weatherStartTime: String,
    val weatherTemperature: Double
)
