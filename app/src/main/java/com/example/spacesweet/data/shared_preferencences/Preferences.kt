package com.example.spacesweet.data.shared_preferencences

import android.content.Context

class Preferences(val context: Context) {

    val SHARED_NAME = "Database"
    val SHARED_NUMBER_PLANETS = "planets"
    val SHARED_SESSION = "session"
    val SHARED_ASTRONAUTS = "astronauts"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveNumberOfPlanets() {
        storage.edit().putInt(SHARED_NUMBER_PLANETS, getNumberOfPlanets() + 1).apply()
    }
    fun saveAstronauts() {
        storage.edit().putInt(SHARED_ASTRONAUTS, getAstronauts() + 1).apply()
    }
    fun saveSession(session:Boolean) {
        storage.edit().putBoolean(SHARED_SESSION, session).apply()
    }

    fun getNumberOfPlanets():Int {
        return storage.getInt(SHARED_NUMBER_PLANETS, 0)
    }
    fun getSession():Boolean {
        return storage.getBoolean(SHARED_SESSION, false)
    }

    fun getAstronauts(): Int {
        return storage.getInt(SHARED_ASTRONAUTS, 0)
    }



}