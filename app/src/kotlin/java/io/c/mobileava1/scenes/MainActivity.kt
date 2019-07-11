package io.c.mobileava1.scenes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.c.mobileava1.R
import io.c.mobileava1.persistence.PreferenceDataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val preferenceDataSource by lazy {
        PreferenceDataSource(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        initListeners()
    }

    private fun initUI() {
        supportActionBar?.title = getString(R.string.label_main_screen)
    }

    private fun initListeners() {
        configureBTN?.setOnClickListener {
            startActivity(Intent(this, ConfigActivity::class.java))
        }
        logoutBTN?.setOnClickListener {
            preferenceDataSource.setLoggedIn(false)
            finish()
        }
    }
}
