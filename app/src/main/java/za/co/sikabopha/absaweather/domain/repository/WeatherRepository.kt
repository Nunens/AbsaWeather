package za.co.sikabopha.absaweather.domain.repository

import kotlinx.coroutines.flow.Flow
import za.co.sikabopha.absaweather.domain.model.Weather
import za.co.sikabopha.absaweather.domain.resource.Resource

interface WeatherRepository {
    suspend fun getWeather(): Flow<Resource<List<Weather>>>
}