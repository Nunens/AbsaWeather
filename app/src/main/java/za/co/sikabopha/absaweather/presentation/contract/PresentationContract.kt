package za.co.sikabopha.absaweather.presentation.contract

import androidx.compose.runtime.Composable

interface PresentationContract {
    interface View{
        @Composable
        fun showProgressView()

        @Composable
        fun showErrorView()

        @Composable
        fun showMainScreen()
    }

    interface VM{
        fun getWeather()
    }
}