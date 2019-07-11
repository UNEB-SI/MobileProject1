package io.c.mobileava1.scenes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import io.c.mobileava1.R;
import io.c.mobileava1.persistence.PreferenceDataSource;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

public final class LoginActivity extends AppCompatActivity {

    PreferenceDataSource preferencesDataSource;
    Button loginBTN;
    Button cancellBTN;
    EditText userEDT;
    EditText passwordEDT;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferencesDataSource = new PreferenceDataSource(this);
        initUI();
        initListeners();
    }

    private void initUI() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.label_login_screen));
        }

        if (preferencesDataSource.isLoggedIn()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        mayBlockApp();
    }

    private void initListeners() {
        loginBTN = findViewById(R.id.loginBTN);
        if (loginBTN != null) {
            loginBTN.setOnClickListener((new OnClickListener() {
                public final void onClick(View it) {
                    String user = "";
                    userEDT = findViewById(R.id.userEDT);
                    if (userEDT != null) {
                        user = userEDT.getText().toString();
                    }

                    String password = "";
                    passwordEDT = findViewById(R.id.passwordEDT);
                    if (passwordEDT != null) {
                        password = passwordEDT.getText().toString();
                    }

                    if (login(user, password)) {
                        preferencesDataSource.setFailLoginCount(0);
                        preferencesDataSource.setLoggedIn(true);
                        LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        userEDT = findViewById(R.id.userEDT);
                        userEDT.setText("");

                        passwordEDT = findViewById(R.id.passwordEDT);
                        passwordEDT.setText("");

                        mayBlockApp();
                        preferencesDataSource.addFailLoginCount();
                        Toast.makeText(LoginActivity.this, getString(R.string.error_wrong_user_and_password), Toast.LENGTH_LONG).show();
                    }

                }
            }));
        }

        cancellBTN = findViewById(R.id.cancellBTN);
        if (cancellBTN != null) {
            cancellBTN.setOnClickListener(new OnClickListener() {
                public final void onClick(View it) {
                    finishAffinity();
                }
            });
        }

    }

    private boolean login(String username, String password) {
        return Intrinsics.areEqual(preferencesDataSource.getUsername(), username) && Intrinsics.areEqual(preferencesDataSource.getPassword(), password);
    }

    private void mayBlockApp() {
        if (preferencesDataSource.getFailLoginCount() == 3) {
            startActivity(new Intent(this, BlockAppActivity.class));
            finish();
        }

    }
}
