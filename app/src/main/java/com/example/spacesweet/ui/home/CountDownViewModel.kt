package com.example.spacesweet.ui.home

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacesweet.ui.home.TimeFormat.timeFormat
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class CountDownViewModel: ViewModel() {
    private var countDownTimer: CountDownTimer? = null

    val userInputHours = mutableStateOf(0)
    val userInputMinutes = mutableStateOf(0)
    val userInputSeconds = mutableStateOf(0)

    private var hours = TimeUnit.HOURS.toMillis(userInputHours.value.toLong() )
    private var minutes = TimeUnit.MINUTES.toMillis(userInputMinutes.value.toLong())
    private var seconds = TimeUnit.SECONDS.toMillis(userInputSeconds.value.toLong())

    private val initialTotalTimeInMillis = hours + minutes + seconds
    var timeLeft = mutableStateOf(initialTotalTimeInMillis)
    val countDownInterval = 1000L // 1 seconds is the lowest

    val timerText = mutableStateOf(timeLeft.value.timeFormat())

    val hasFinished = mutableStateOf(false)

    fun startCountDownTimer() = viewModelScope.launch {
        hours = TimeUnit.HOURS.toMillis(userInputHours.value.toLong())
        minutes = TimeUnit.MINUTES.toMillis(userInputMinutes.value.toLong())
        seconds = TimeUnit.SECONDS.toMillis(userInputSeconds.value.toLong())
        val initialTotalTimeInMillis = hours + minutes + seconds
        timeLeft.value = initialTotalTimeInMillis
        timerText.value = timeLeft.value.timeFormat()

        countDownTimer = object : CountDownTimer(timeLeft.value, countDownInterval) {
            override fun onTick(currentTimeLeft: Long) {
                timerText.value = currentTimeLeft.timeFormat()
                timeLeft.value = currentTimeLeft
            }


            override fun onFinish() {
                Log.e("hour", hours.toString())
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