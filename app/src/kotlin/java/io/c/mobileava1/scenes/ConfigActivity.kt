package io.c.mobileava1.scenes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.c.mobileava1.R
import io.c.mobileava1.persistence.PreferenceDataSource
import kotlinx.android.synthetic.main.activity_config.*
import kotlinx.android.synthetic.main.activity_login.cancellBTN
import kotlinx.android.synthetic.main.activity_login.passwordEDT
import kotlinx.android.synthetic.main.activity_login.userEDT

class ConfigActivity : AppCompatActivity() {

    private val preferenceDataSource by lazy {
        PreferenceDataSource(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        initUI()
        initListeners()
    }

    private fun initUI() {
        supportActionBar?.title = getString(R.string.label_configuration_screen)
    }

    private fun initListeners() {
        confirmBTN?.setOnClickListener {
            val user = userEDT?.text?.toString()
            val password = passwordEDT?.text?.toString()
            val confirmPassword = confirmPasswordEDT?.text?.toString()
            if (password == confirmPassword) {
                preferenceDataSource.apply {
                    user?.let {
                        setUsername(user)
                    } ?: run {
                        Toast.makeText(this@ConfigActivity, getString(R.string.error_unkown), Toast.LENGTH_LONG).show()
                    }
                    password?.let {
                        setPassword(password)
                    } ?: run {
                        Toast.makeText(this@ConfigActivity, getString(R.string.error_unkown), Toast.LENGTH_LONG).show()
                    }
                }
                finish()
            } else {
                Toast.makeText(this, getString(R.string.error_different_password), Toast.LENGTH_LONG).show()

            }
        }

        cancellBTN?.setOnClickListener {
            finish()
        }
    }
}
