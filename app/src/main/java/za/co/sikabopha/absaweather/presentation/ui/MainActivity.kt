package za.co.sikabopha.absaweather.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import za.co.sikabopha.absaweather.presentation.contract.PresentationContract
import za.co.sikabopha.absaweather.presentation.ui.screen.ErrorView
import za.co.sikabopha.absaweather.presentation.ui.screen.MainScreenView
import za.co.sikabopha.absaweather.presentation.ui.screen.ProgressView
import za.co.sikabopha.absaweather.presentation.viewmodel.WeatherViewModel
import za.co.sikabopha.absaweather.ui.theme.AbsaWeatherTheme

class MainActivity : ComponentActivity(), PresentationContract.View {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getWeather()
        setContent {
            AbsaWeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (viewModel.state.value.isLoading) {
                        showProgressView()
                    } else if (viewModel.state.value.error.isNotEmpty()) {
                        showErrorView()
                    } else {
                        showMainScreen()
                    }
                }
            }
        }
    }

    @Composable
    override fun showProgressView() {
        ProgressView()
    }

    @Composable
    override fun showErrorView() {
        ErrorView(error = viewModel.state.value.error)
    }

    @Composable
    override fun showMainScreen() {
        MainScreenView(viewModel.state.value.weatherList)
    }
}