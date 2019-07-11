package io.c.mobileava1.scenes;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import io.c.mobileava1.R;
import io.c.mobileava1.R.id;
import io.c.mobileava1.persistence.PreferenceDataSource;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

public final class ConfigActivity extends AppCompatActivity {

    PreferenceDataSource preferencesDataSource;
    Button confirmBTN;
    Button cancellBTN;
    EditText userEDT;
    EditText passwordEDT;
    EditText confirmPasswordEDT;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        preferencesDataSource = new PreferenceDataSource(this);
        initUI();
        initListeners();
    }

    private void initUI() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.label_configuration_screen));
        }
    }

    private void initListeners() {
        confirmBTN = findViewById(R.id.confirmBTN);
        if (confirmBTN != null) {
            confirmBTN.setOnClickListener(new OnClickListener() {
                public final void onClick(View it) {
                    Editable var15;
                    String var16;
                    label45:
                    {
                        userEDT = findViewById(id.userEDT);
                        if (userEDT != null) {
                            var15 = userEDT.getText();
                            if (var15 != null) {
                                var16 = var15.toString();
                                break label45;
                            }
                        }

                        var16 = null;
                    }

                    String user;
                    label40:
                    {
                        user = var16;
                        passwordEDT = findViewById(id.passwordEDT);
                        if (passwordEDT != null) {
                            var15 = passwordEDT.getText();
                            if (var15 != null) {
                                var16 = var15.toString();
                                break label40;
                            }
                        }

                        var16 = null;
                    }

                    String password;
                    label35:
                    {
                        password = var16;
                        confirmPasswordEDT = findViewById(id.confirmPasswordEDT);
                        if (confirmPasswordEDT != null) {
                            var15 = confirmPasswordEDT.getText();
                            if (var15 != null) {
                                var16 = var15.toString();
                                break label35;
                            }
                        }

                        var16 = null;
                    }

                    String confirmPassword = var16;
                    if (Intrinsics.areEqual(password, confirmPassword)) {
                        if (user != null) {
                            preferencesDataSource.setUsername(user);
                        } else {
                            Toast.makeText(ConfigActivity.this, ConfigActivity.this.getString(R.string.error_unkown), Toast.LENGTH_LONG).show();
                        }

                        if (password != null) {
                            preferencesDataSource.setPassword(password);
                        } else {
                            Toast.makeText(ConfigActivity.this, ConfigActivity.this.getString(R.string.error_unkown), Toast.LENGTH_LONG).show();
                        }

                        ConfigActivity.this.finish();
                    } else {
                        Toast.makeText(ConfigActivity.this, getString(R.string.error_different_password), Toast.LENGTH_LONG).show();
                    }

                }
            });
        }

        cancellBTN = findViewById(R.id.cancellBTN);
        if (cancellBTN != null) {
            cancellBTN.setOnClickListener(new OnClickListener() {
                public final void onClick(View it) {
                    finish();
                }
            });
        }

    }
}
