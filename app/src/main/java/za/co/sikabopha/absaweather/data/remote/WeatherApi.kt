package za.co.sikabopha.absaweather.data.remote

import retrofit2.http.GET
import za.co.sikabopha.absaweather.data.entity.Timeline
import java.util.*

interface WeatherApi {
    companion object {
        const val BASE_URL = "https://api.tomorrow.io/v4/"
        //timelines?location=-73.98529171943665,40.75872069597532&fields=
        // temperature&timesteps=1h&units=metric&
        // apikey=pI5Yg97fDKwgcrxGMjUn1JoP8MA4ALCS"
        //TODO: below is a full curl script - produces json response
        //curl --request GET --url 'https://api.tomorrow.io/v4/timelines?location=-73.98529171943665,40.75872069597532&fields=temperature&timesteps=1h&units=metric&apikey=pI5Yg97fDKwgcrxGMjUn1JoP8MA4ALCS'
    }

    @GET("timelines")
    suspend fun getWeather(): List<Timeline>
}