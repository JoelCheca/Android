package com.davidchura.sistemamarina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            mostrarMain();
        }, 4000)
    }

    private fun mostrarMain() {
        startActivity(Intent(this,MainActivity::class.java) )
        finish()
    }
}