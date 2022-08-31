package za.co.sikabopha.absaweather.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import za.co.sikabopha.absaweather.domain.model.Weather
import za.co.sikabopha.absaweather.presentation.ui.components.WeatherItem
import za.co.sikabopha.absaweather.presentation.ui.screen.ErrorView
import za.co.sikabopha.absaweather.presentation.ui.screen.MainScreenView
import za.co.sikabopha.absaweather.presentation.ui.screen.ProgressView
import za.co.sikabopha.absaweather.presentation.viewmodel.WeatherViewmodel
import za.co.sikabopha.absaweather.ui.theme.AbsaWeatherTheme

class MainActivity : ComponentActivity() {
    private val viewmodel: WeatherViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel.getWeather()
        setContent {
            AbsaWeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (viewmodel.state.value.isLoading) {
                        ProgressView()
                    } else if (viewmodel.state.value.error.isNotEmpty()) {
                        ErrorView(error = viewmodel.state.value.error)
                    } else {
                        MainScreenView(viewmodel.state.value.weatherList)
                    }
                }
            }
        }
    }
}