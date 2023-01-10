package com.example.homework11.settings

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SharedPrefManager(private val ctx: Context) {
    private var preferences: SharedPreferences? = null
    private var defaultSp: SharedPreferences? = null

    init {
        preferences = ctx.getSharedPreferences(DEFAULT_SP_KEY, Context.MODE_PRIVATE)
        defaultSp = PreferenceManager.getDefaultSharedPreferences(ctx)
    }

    fun getUsername(): String {
        val username = preferences?.getString(USERNAME_KEY, "") ?: ""
        return username
    }

    fun saveUsername(username: String) {
        preferences?.edit()?.apply {
            this.putString(USERNAME_KEY, username)
                .apply()
        }
        defaultSp?.edit().apply {
            this?.putString(USERNAME_KEY, username)
        }?.apply()
    }

    companion object {
        private const val USERNAME_KEY = "USERNAME_KEY"
        private const val DEFAULT_SP_KEY = "DEFAULT_SP_KEY"
    }
}