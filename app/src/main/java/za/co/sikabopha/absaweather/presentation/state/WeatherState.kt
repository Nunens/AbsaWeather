package za.co.sikabopha.absaweather.presentation.state

import za.co.sikabopha.absaweather.domain.model.Weather

data class WeatherState(
    val weatherList: List<Weather> = emptyList(),
    val error: String = "",
    val selectedIndex: Int = 0,
    val isLoading: Boolean = false,
)
