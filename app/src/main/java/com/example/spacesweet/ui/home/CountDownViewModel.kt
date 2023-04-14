package com.example.spacesweet.ui.home

import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacesweet.ui.home.TimeFormat.timeFormat
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class CountDownViewModel: ViewModel() {
    private var countDownTimer: CountDownTimer? = null

    private val userInputHour = TimeUnit.HOURS.toMillis(0)
    private val userInputMinute = TimeUnit.MINUTES.toMillis(0)
    private val userInputSecond = TimeUnit.SECONDS.toMillis(3)

    val initialTotalTimeInMillis = userInputHour + userInputMinute + userInputSecond
    var timeLeft = mutableStateOf(initialTotalTimeInMillis)
    val countDownInterval = 1000L // 1 seconds is the lowest

    val timerText = mutableStateOf(timeLeft.value.timeFormat())

    val hasFinished = mutableStateOf(false)

    fun startCountDownTimer() = viewModelScope.launch {
        countDownTimer = object : CountDownTimer(timeLeft.value, countDownInterval) {
            override fun onTick(currentTimeLeft: Long) {
                timerText.value = currentTimeLeft.timeFormat()
                timeLeft.value = currentTimeLeft
            }

            override fun onFinish() {
                timerText.value = initialTotalTimeInMillis.timeFormat()
                hasFinished.value = true
                timerText.value = initialTotalTimeInMillis.timeFormat()
                timeLeft.value = initialTotalTimeInMillis
                countDownTimer?.cancel()
            }
        }.start()
    }
    fun stopCountDownTimer() {
        countDownTimer?.cancel()
        hasFinished.value = false
        timeLeft.value = initialTotalTimeInMillis
        timerText.value = timeLeft.value.timeFormat()
    }
}