package com.puhovdev.appforsearhfilms

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.puhovdev.appforsearhfilms.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        supportActionBar?.hide()
        CoroutineScope(Dispatchers.Main).launch {
            delay(1520L)
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }
    }
}