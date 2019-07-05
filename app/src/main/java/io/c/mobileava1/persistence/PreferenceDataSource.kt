package io.c.mobileava1.persistence

import android.content.Context
import android.preference.PreferenceManager

class PreferenceDataSource(context: Context) {
    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)!!

    fun setUsername(user: String) = sharedPreferences.edit().putString(PreferenceKeys.USERNAME.name, user).apply()

    fun getUsername(): String? = sharedPreferences.getString(PreferenceKeys.USERNAME.name, null)

    fun setPassword(user: String) = sharedPreferences.edit().putString(PreferenceKeys.PASSWORD.name, user).apply()

    fun getPassword(): String? = sharedPreferences.getString(PreferenceKeys.PASSWORD.name, null)

    fun setFailLoginCount(failLoginCount: Int) = sharedPreferences.edit().putInt(PreferenceKeys.FAIL_LOGIN_COUNT.name, failLoginCount).apply()

    fun getFailLoginCount(): Int = sharedPreferences.getInt(PreferenceKeys.FAIL_LOGIN_COUNT.name, 0)

    fun addFailLoginCount () = setFailLoginCount(getFailLoginCount() + 1)

    fun setLoggedIn(loggedIn: Boolean) = sharedPreferences.edit().putBoolean(PreferenceKeys.LOGGED_IN.name, loggedIn).apply()

    fun isLoggedIn(): Boolean = sharedPreferences.getBoolean(PreferenceKeys.LOGGED_IN.name, false)


    enum class PreferenceKeys {
        USERNAME, PASSWORD, FAIL_LOGIN_COUNT, LOGGED_IN
    }
}
