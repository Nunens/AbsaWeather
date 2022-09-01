package za.co.sikabopha.absaweather.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import za.co.sikabopha.absaweather.domain.repository.WeatherRepository
import za.co.sikabopha.absaweather.presentation.state.WeatherState
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import za.co.sikabopha.absaweather.domain.resource.Resource
import za.co.sikabopha.absaweather.presentation.contract.PresentationContract

@HiltViewModel
class WeatherViewModel @Inject constructor() : ViewModel(), PresentationContract.VM {
    @Inject
    lateinit var repository: WeatherRepository

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    override fun getWeather(){
        viewModelScope.async{
            repository.getWeather()
                .collect { resp ->
                    when(resp){
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                isLoading = resp.isLoading
                            )
                        }
                        is Resource.Success -> {
                            resp.data?.let {
                                _state.value = state.value.copy(
                                    weatherList = it
                                )
                            }
                        }
                        else -> {
                            _state.value = state.value.copy(
                                error = resp.message.toString()
                            )
                        }
                    }
                }
        }
    }
}