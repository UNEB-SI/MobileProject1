package io.c.mobileava1.scenes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.c.mobileava1.R
import io.c.mobileava1.persistence.PreferenceDataSource
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val preferenceDataSource by lazy {
        PreferenceDataSource(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUi()
        initListeners()
    }

    private fun initUi() {
        supportActionBar?.title = getString(R.string.label_login_screen)
        if (preferenceDataSource.isLoggedIn()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        mayBlockApp()
    }

    private fun initListeners() {
        loginBTN?.setOnClickListener {
            if (login(userEDT?.text?.toString() ?: "", passwordEDT?.text?.toString() ?: "")) {
                preferenceDataSource.apply {
                    setFailLoginCount(0)
                    setLoggedIn(true)
                }
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                userEDT?.setText("")
                passwordEDT?.setText("")
                preferenceDataSource.addFailLoginCount()
                mayBlockApp()
                Toast.makeText(this, getString(R.string.error_wrong_user_and_password), Toast.LENGTH_LONG).show()
            }
        }

        cancellBTN?.setOnClickListener {
            finishAffinity()
        }
    }

    private fun login(username: String, password: String) =
        preferenceDataSource.let {
            it.getUsername() == username && it.getPassword() == password

        }

    private fun mayBlockApp() {
        if (preferenceDataSource.getFailLoginCount() == 3) {
            startActivity(Intent(this, BlockAppActivity::class.java))
            finish()
        }
    }
}
