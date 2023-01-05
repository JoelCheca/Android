package com.davidchura.sistemamarina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class EmpezarActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empezar)
        val btnInicioSesion: Button = findViewById(R.id.btnInicioSesion)
        val btnTerminos: Button = findViewById(R.id.btnTerminos)

        btnInicioSesion.setOnClickListener(this)
        btnTerminos.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnTerminos -> startActivity(Intent(this,
                TerminosActivity::class.java))
            R.id.btnInicioSesion -> startActivity(Intent(this,
                LoginActivity::class.java))
        }
    }
}