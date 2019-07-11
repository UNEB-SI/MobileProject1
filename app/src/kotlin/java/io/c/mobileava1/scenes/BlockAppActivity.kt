package io.c.mobileava1.scenes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import io.c.mobileava1.R

class BlockAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(LinearLayout.SYSTEM_UI_FLAG_FULLSCREEN)
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.error_app_blocked))
            .setMessage(getString(R.string.error_app_blocked_description))
            .setOnDismissListener { finishAffinity() }
            .show()
    }
}
