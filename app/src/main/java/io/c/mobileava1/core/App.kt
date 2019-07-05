package io.c.mobileava1.core

import android.app.Application
import io.c.mobileava1.persistence.PreferenceDataSource

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferenceDataSource(this).apply {
            getUsername() ?: run {
                setUsername("admin")
            }
            getPassword() ?: run {
                setPassword("admin")
            }
        }
    }
}
