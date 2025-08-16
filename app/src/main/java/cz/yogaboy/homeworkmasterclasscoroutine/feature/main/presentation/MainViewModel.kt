package cz.yogaboy.homeworkmasterclasscoroutine.feature.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.yogaboy.homeworkmasterclasscoroutine.domain.usecase.StartJobs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val startJobs: StartJobs) : ViewModel() {

    private val _result = MutableStateFlow<Pair<String, Long>?>(null)
    val result: StateFlow<Pair<String, Long>?> = _result

    fun run() {
        viewModelScope.launch {
            val (name, duration) = startJobs()
            _result.value = name to duration
        }
    }
}