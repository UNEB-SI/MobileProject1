package io.c.mobileava1.scenes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import io.c.mobileava1.R;
import io.c.mobileava1.R.id;
import io.c.mobileava1.persistence.PreferenceDataSource;
import org.jetbrains.annotations.Nullable;

public final class MainActivity extends AppCompatActivity {

    Button configureBTN;
    Button logoutBTN;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initListeners();
    }

    private void initUI() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.label_main_screen));
        }
    }

    private void initListeners() {
        configureBTN = findViewById(R.id.configureBTN);
        if (configureBTN != null) {
            configureBTN.setOnClickListener(new OnClickListener() {
                public final void onClick(View it) {
                    startActivity(new Intent(MainActivity.this, ConfigActivity.class));
                }
            });
        }

        logoutBTN = findViewById(id.logoutBTN);
        if (logoutBTN != null) {
            logoutBTN.setOnClickListener(new OnClickListener() {
                public final void onClick(View it) {
                    PreferenceDataSource preferencesDataSource = new PreferenceDataSource(MainActivity.this);
                    preferencesDataSource.setLoggedIn(false);
                    finish();
                }
            });
        }

    }
}
