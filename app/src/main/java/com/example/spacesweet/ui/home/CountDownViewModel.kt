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

    val hour = mutableStateOf(0)

    private var userInputHour = TimeUnit.HOURS.toMillis(hour.value.toLong() )
    private val userInputMinute = TimeUnit.MINUTES.toMillis(0)
    private val userInputSecond = TimeUnit.SECONDS.toMillis(3)

    val initialTotalTimeInMillis = userInputHour + userInputMinute + userInputSecond
    var timeLeft = mutableStateOf(initialTotalTimeInMillis)
    val countDownInterval = 1000L // 1 seconds is the lowest

    val timerText = mutableStateOf(timeLeft.value.timeFormat())

    val hasFinished = mutableStateOf(false)

    fun startCountDownTimer() = viewModelScope.launch {
        userInputHour = TimeUnit.HOURS.toMillis(hour.value.toLong()) // Actualiza el valor de userInputHour
        val initialTotalTimeInMillis = userInputHour + userInputMinute + userInputSecond // Calcula el tiempo total inicial con el valor de hora actualizado
        timeLeft.value = initialTotalTimeInMillis // Actualiza el valor de timeLeft con el tiempo total inicial actualizado
        timerText.value = timeLeft.value.timeFormat() // Actualiza el texto del temporizador con el nuevo valor de timeLeft

        countDownTimer = object : CountDownTimer(timeLeft.value, countDownInterval) {
            override fun onTick(currentTimeLeft: Long) {
                timerText.value = currentTimeLeft.timeFormat()
                timeLeft.value = currentTimeLeft
            }


            override fun onFinish() {
                Log.e("hour", userInputHour.toString())
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