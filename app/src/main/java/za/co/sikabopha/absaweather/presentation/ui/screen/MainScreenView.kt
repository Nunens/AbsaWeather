package za.co.sikabopha.absaweather.presentation.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import za.co.sikabopha.absaweather.domain.model.Weather
import za.co.sikabopha.absaweather.presentation.ui.components.WeatherItem

@Composable
fun MainScreenView(weatherList: List<Weather>) {
    LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
        itemsIndexed(items = weatherList) { _, item ->
            WeatherItem(weather = item)
        }
    }
}