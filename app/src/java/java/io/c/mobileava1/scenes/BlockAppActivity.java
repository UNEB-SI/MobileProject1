package io.c.mobileava1.scenes;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import io.c.mobileava1.R;

public final class BlockAppActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(LinearLayout.SYSTEM_UI_FLAG_FULLSCREEN);
        (new Builder(this))
                .setTitle(getString(R.string.error_app_blocked))
                .setMessage(getString(R.string.error_app_blocked_description))
                .setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface it) {
                        finishAffinity();
                    }
                }).show();
    }
}
