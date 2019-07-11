package io.c.mobileava1.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public final class PreferenceDataSource {

    private final SharedPreferences sharedPreferences;

    public final void setUsername(String user) {
        this.sharedPreferences.edit().putString(PreferenceDataSource.PreferenceKeys.USERNAME.name(), user).apply();
    }

    public final String getUsername() {
        return this.sharedPreferences.getString(PreferenceDataSource.PreferenceKeys.USERNAME.name(), null);
    }

    public final void setPassword(String user) {
        this.sharedPreferences.edit().putString(PreferenceDataSource.PreferenceKeys.PASSWORD.name(), user).apply();
    }

    public final String getPassword() {
        return this.sharedPreferences.getString(PreferenceDataSource.PreferenceKeys.PASSWORD.name(), null);
    }

    public final void setFailLoginCount(int failLoginCount) {
        this.sharedPreferences.edit().putInt(PreferenceDataSource.PreferenceKeys.FAIL_LOGIN_COUNT.name(), failLoginCount).apply();
    }

    public final int getFailLoginCount() {
        return this.sharedPreferences.getInt(PreferenceDataSource.PreferenceKeys.FAIL_LOGIN_COUNT.name(), 0);
    }

    public final void addFailLoginCount() {
        this.setFailLoginCount(this.getFailLoginCount() + 1);
    }

    public final void setLoggedIn(boolean loggedIn) {
        this.sharedPreferences.edit().putBoolean(PreferenceDataSource.PreferenceKeys.LOGGED_IN.name(), loggedIn).apply();
    }

    public final boolean isLoggedIn() {
        return this.sharedPreferences.getBoolean(PreferenceDataSource.PreferenceKeys.LOGGED_IN.name(), false);
    }

    public PreferenceDataSource(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public enum PreferenceKeys {
        USERNAME,
        PASSWORD,
        FAIL_LOGIN_COUNT,
        LOGGED_IN
    }
}
