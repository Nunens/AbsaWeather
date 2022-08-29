package za.co.sikabopha.absaweather.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import za.co.sikabopha.absaweather.data.remote.WeatherApi
import za.co.sikabopha.absaweather.domain.model.Weather
import za.co.sikabopha.absaweather.domain.repository.WeatherRepository
import za.co.sikabopha.absaweather.domain.resource.Resource
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeather(): Flow<Resource<List<Weather>>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                //TODO: pass location(lan, lon) as parameters
                val resp = api.getWeather()
                val data: List<Weather> = resp.map {
                    Weather(
                        it.timestamp,
                        it.startTime,
                        it.endtime,
                        it.intervals.startTime,
                        it.intervals.values.temperature
                    )
                }
                emit(Resource.Success(data = data))
                emit(Resource.Loading(isLoading = false))
            } catch (e: HttpException) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(message = "${e.message}"))
            } catch (e: IOException) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(message = "${e.message}"))
            } catch (e: Exception) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(message = "${e.message}"))
            }
        }
    }
}