package com.example.foodmarket

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.multidex.MultiDexApplication
import com.example.foodmarket.network.HttpClient

class FoodMarket : MultiDexApplication() {

    companion object {
        lateinit var instance: FoodMarket

        fun getApp() : FoodMarket {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    fun getPreference() : SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(this)
    }

    fun setToken(token: String?) {
        getPreference().edit().putString("PREFERENCES_TOKEN", token).apply()
        if (token != null) {
            HttpClient.getInstance().buildRetrofitClient(token)
        }
    }

    fun getToken() : String? {
        return getPreference().getString("PREFERENCES_TOKEN",null)
    }

    fun setUser(user: String) {
        getPreference().edit().putString("PREFERENCES_USER", user).apply()
        HttpClient.getInstance().buildRetrofitClient(user)
    }

    fun getUser() : String? {
        return getPreference().getString("PREFERENCES_USER",null)
    }
}