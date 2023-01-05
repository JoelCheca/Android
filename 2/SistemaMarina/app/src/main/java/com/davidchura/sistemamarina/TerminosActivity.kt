package com.davidchura.sistemamarina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TerminosActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terminos)
        val btnCerrar: Button = findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        finish()
    }
}