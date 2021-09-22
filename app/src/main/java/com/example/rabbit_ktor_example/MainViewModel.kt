package com.example.rabbit_ktor_example

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rabbit_ktor_example.data.Rabbit
import com.example.rabbit_ktor_example.data.RabbitsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: RabbitsApi
): ViewModel() {

    val state = mutableStateOf(RabbitState())


    init {
        getRandomRabbit()
    }

    fun getRandomRabbit() {
        viewModelScope.launch {
            state.value = state.value.copy(isLoading = true)
            delay(2500)
            try {
                state.value = state.value.copy(
                    rabbit = api.getRandomRabbit(),
                    isLoading = false
                )
            } catch (e: Exception) {
                Log.e("MainViewModel", "getRandomRabbit: ", e)
                state.value = state.value.copy(isLoading = false)
            }
            state.value = state.value.copy(isLoading = false)
        }
    }

    fun getFirstRabbit() {
        viewModelScope.launch {
            state.value = state.value.copy(isLoading = true)
            delay(2500)
            try {
                state.value = state.value.copy(
                    rabbit = api.getFirstRabbit(),
                    isLoading = false
                )
            } catch (e: Exception) {
                Log.e("MainViewModel", "getFirstRabbit: ", e)
                state.value = state.value.copy(isLoading = false)
            }
            state.value = state.value.copy(isLoading = false)
        }
    }

    fun getSecondRabbit() {
        viewModelScope.launch {
            state.value = state.value.copy(isLoading = true)
            delay(2500)
            try {
                state.value = state.value.copy(
                    rabbit = api.getSecondRabbit(),
                    isLoading = false
                )
            } catch (e: Exception) {
                Log.e("MainViewModel", "getFirstRabbit: ", e)
                state.value = state.value.copy(isLoading = false)
            }
            state.value = state.value.copy(isLoading = false)
        }
    }

    fun getThirdRabbit() {
        viewModelScope.launch {
            state.value = state.value.copy(isLoading = true)
            delay(2500)
            try {
                state.value = state.value.copy(
                    rabbit = api.getThirdRabbit(),
                    isLoading = false
                )
            } catch (e: Exception) {
                Log.e("MainViewModel", "getFirstRabbit: ", e)
                state.value = state.value.copy(isLoading = false)
            }
            state.value = state.value.copy(isLoading = false)
        }
    }

    fun getFourthRabbit() {
        viewModelScope.launch {
            state.value = state.value.copy(isLoading = true)
            delay(2500)
            try {
                state.value = state.value.copy(
                    rabbit = api.getFourthRabbit(),
                    isLoading = false
                )
            } catch (e: Exception) {
                Log.e("MainViewModel", "getFirstRabbit: ", e)
                state.value = state.value.copy(isLoading = false)
            }
            state.value = state.value.copy(isLoading = false)
        }
    }

    fun getFifthRabbit() {
        viewModelScope.launch {
            state.value = state.value.copy(isLoading = true)
            delay(2500)
            try {
                state.value = state.value.copy(
                    rabbit = api.getFifthRabbit(),
                    isLoading = false
                )
            } catch (e: Exception) {
                Log.e("MainViewModel", "getFirstRabbit: ", e)
                state.value = state.value.copy(isLoading = false)
            }
            state.value = state.value.copy(isLoading = false)
        }
    }

    data class RabbitState(
        val rabbit: Rabbit? = null,
        val isLoading: Boolean = false
    )
}