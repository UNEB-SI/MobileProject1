package io.c.mobileava1.core;

import android.app.Application;
import android.content.Context;
import io.c.mobileava1.persistence.PreferenceDataSource;
import kotlin.Metadata;
import kotlin.Unit;

public final class App extends Application {
    public void onCreate() {
        super.onCreate();
        PreferenceDataSource preferencesDataSource = new PreferenceDataSource(this);
        if (preferencesDataSource.getUsername() == null) {
            preferencesDataSource.setUsername("admin");
        }

        if (preferencesDataSource.getPassword() == null) {
            preferencesDataSource.setPassword("admin");
        }

    }
}
